package com.ird.portal.dao.hibernate;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.hibernate.transform.BasicTransformerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.NotWritablePropertyException;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * @see org.hibernate.transform.BasicTransformerAdapter
 */
public class BeanTransformerAdapter extends BasicTransformerAdapter {

    /** 
     *
     */
    private static final long serialVersionUID = -7023217078657702302L;

    /**
     * Logger available to subclasses
     */
    protected final Logger LOGGER = LoggerFactory.getLogger(BeanTransformerAdapter.class);

    /**
     * The class we are mapping to
     */
    @SuppressWarnings("rawtypes")
    private Class mappedClass;

    /**
     * Whether we're strictly validating
     */
    private boolean checkFullyPopulated = false;

    /**
     * Whether we're defaulting primitives when mapping a null value
     */
    private boolean primitivesDefaultedForNullValue = false;

    /**
     * Map of the fields we provide mapping for
     */
    private Map<String, PropertyDescriptor> mappedFields;

    /**
     * Set of bean properties we provide mapping for
     */
    private Set<String> mappedProperties;

    /**
     * mappedClass new Instance.
     */
    private Object mappedObject;

    private BeanWrapper bw;

    /**
     * Create a new BeanPropertyRowMapper, accepting unpopulated properties
     * in the target bean.
     * <p>Consider using the {@link #newInstance} factory method instead,
     * which allows for specifying the mapped type once only.
     *
     * @param mappedClass the class that each row should be mapped to
     */
    public BeanTransformerAdapter(@SuppressWarnings("rawtypes") Class mappedClass) {
        initialize(mappedClass);

        instantiateMappedClass(mappedClass);
    }

    /**
     * Create a new BeanPropertyRowMapper.
     *
     * @param mappedClass         the class that each row should be mapped to
     * @param checkFullyPopulated whether we're strictly validating that
     *                            all bean properties have been mapped from corresponding database fields
     */
    public BeanTransformerAdapter(@SuppressWarnings("rawtypes") Class mappedClass, boolean checkFullyPopulated) {
        initialize(mappedClass);
        instantiateMappedClass(mappedClass);
        this.checkFullyPopulated = checkFullyPopulated;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void instantiateMappedClass(Class mappedClass) {
        mappedObject = BeanUtils.instantiate(mappedClass);
        bw = PropertyAccessorFactory.forBeanPropertyAccess(mappedObject);
        initBeanWrapper(bw);
    }

    /**
     * Set the class that each row should be mapped to.
     */
    public void setMappedClass(@SuppressWarnings("rawtypes") Class mappedClass) {
        if (this.mappedClass == null) {
            initialize(mappedClass);
        } else {
            if (!this.mappedClass.equals(mappedClass)) {
                throw new InvalidDataAccessApiUsageException("The mapped class can not be reassigned to map to " +
                        mappedClass + " since it is already providing mapping for " + this.mappedClass);
            }
        }
    }

    /**
     * Initialize the mapping metadata for the given class.
     *
     * @param mappedClass the mapped class.
     */
    protected void initialize(@SuppressWarnings("rawtypes") Class mappedClass) {
        this.mappedClass = mappedClass;
        this.mappedFields = new HashMap<>();
        this.mappedProperties = new HashSet<>();
        PropertyDescriptor[] pds = BeanUtils.getPropertyDescriptors(mappedClass);
        for (PropertyDescriptor pd : pds) {
            if (pd.getWriteMethod() != null) {
                this.mappedFields.put(pd.getName().toLowerCase(), pd);
                String underscoredName = underscoreName(pd.getName());
                if (!pd.getName().toLowerCase().equals(underscoredName)) {
                    this.mappedFields.put(underscoredName, pd);
                }
                this.mappedProperties.add(pd.getName());
            }
        }
    }

    /**
     * Convert a name in camelCase to an underscored name in lower case.
     * Any upper case letters are converted to lower case with a preceding underscore.
     *
     * @param name the string containing original name
     * @return the converted name
     */
    private String underscoreName(String name) {
        if (!StringUtils.hasLength(name)) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        result.append(name.substring(0, 1).toLowerCase());
        for (int i = 1; i < name.length(); i++) {
            String s = name.substring(i, i + 1);
            String slc = s.toLowerCase();
            if (!s.equals(slc)) {
                result.append("_").append(slc);
            } else {
                result.append(s);
            }
        }
        return result.toString();
    }

    /**
     * Get the class that we are mapping to.
     */
    @SuppressWarnings("rawtypes")
    public final Class getMappedClass() {
        return this.mappedClass;
    }

    /**
     * Set whether we're strictly validating that all bean properties have been
     * mapped from corresponding database fields.
     * <p>Default is {@code false}, accepting unpopulated properties in the
     * target bean.
     */
    public void setCheckFullyPopulated(boolean checkFullyPopulated) {
        this.checkFullyPopulated = checkFullyPopulated;
    }

    /**
     * Return whether we're strictly validating that all bean properties have been
     * mapped from corresponding database fields.
     */
    public boolean isCheckFullyPopulated() {
        return this.checkFullyPopulated;
    }

    /**
     * Set whether we're defaulting Java primitives in the case of mapping a null value
     * from corresponding database fields.
     * <p>Default is {@code false}, throwing an exception when nulls are mapped to Java primitives.
     */
    public void setPrimitivesDefaultedForNullValue(boolean primitivesDefaultedForNullValue) {
        this.primitivesDefaultedForNullValue = primitivesDefaultedForNullValue;
    }

    /**
     * Return whether we're defaulting Java primitives in the case of mapping a null value
     * from corresponding database fields.
     */
    public boolean isPrimitivesDefaultedForNullValue() {
        return primitivesDefaultedForNullValue;
    }

    @Override
    public Object transformTuple(Object[] tuple, String[] aliases) {
        Assert.state(this.mappedClass != null, "Mapped class was not specified");
        @SuppressWarnings("unchecked")
        Object mappedObject = BeanUtils.instantiate(this.mappedClass);
        BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(mappedObject);
        initBeanWrapper(bw);
        
        Set<String> populatedProperties = (isCheckFullyPopulated() ? new HashSet<String>() : null);

        for (int i = 0; i < aliases.length; i++) {
            String column = aliases[i];
            PropertyDescriptor pd = this.mappedFields.get(column.replaceAll(" ", "").toLowerCase());
            if (pd != null) {
                try {
                    Object value = tuple[i];
                    try {
                    	/*
                    	 * Custom logic for settting TRUE for "Y" and FALSE for "N" for Boolean target
                    	 */
                    	Class<?> propertyType = bw.getPropertyType(pd.getName());
                    	if (Boolean.class.equals(propertyType) && (value instanceof Character)) {
                    		if (Character.toUpperCase(((Character)value).charValue()) == 'Y') {
                    			bw.setPropertyValue(pd.getName(), Boolean.TRUE);
                    		} else if (Character.toUpperCase(((Character)value).charValue()) == 'N') {
                    			bw.setPropertyValue(pd.getName(), Boolean.FALSE);
                    		} else {
                    			bw.setPropertyValue(pd.getName(), value);
                    		}
                    	} else {
                    		bw.setPropertyValue(pd.getName(), value);
                    	}
                    } catch (TypeMismatchException e) {
                        if (value == null && primitivesDefaultedForNullValue) {
                            LOGGER.debug("Intercepted TypeMismatchException for column " + column +
                                    " and column '" + column + "' with value " + value +
                                    " when setting property '" + pd.getName() + "' of type " + pd.getPropertyType() +
                                    " on object: " + mappedObject);
                        } else {
                            throw e;
                        }
                    }
                    if (populatedProperties != null) {
                        populatedProperties.add(pd.getName());
                    }
                } catch (NotWritablePropertyException ex) {
                    throw new DataRetrievalFailureException("Unable to map column " + column
                            + " to property " + pd.getName(), ex);
                }
            }
        }

        if (populatedProperties != null && !populatedProperties.equals(this.mappedProperties)) {
            throw new InvalidDataAccessApiUsageException("Given ResultSet does not contain all fields " +
                    "necessary to populate object of class [" + this.mappedClass + "]: " + this.mappedProperties);
        }

        return mappedObject;
    }

    /**
     * Initialize the given BeanWrapper to be used for row mapping.
     * To be called for each row.
     * <p>The default implementation is empty. Can be overridden in subclasses.
     *
     * @param bw the BeanWrapper to initialize
     */
    protected void initBeanWrapper(BeanWrapper bw) {
    }

    /**
     * Static factory method to create a new ResultTransformer
     * (with the mapped class specified only once).
     *
     * @param mappedClass the class that each row should be mapped to
     */
    public static BeanTransformerAdapter newInstance(@SuppressWarnings("rawtypes") Class mappedClass) {
        return new BeanTransformerAdapter(mappedClass);
    }
}
