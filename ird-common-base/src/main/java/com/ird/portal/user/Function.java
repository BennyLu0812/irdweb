package com.ird.portal.user;

/**
 * Function DTO
 * 
 * @author SPISTEV
 * 
 */
public class Function {

	/**
		 * 
		 */
	private static final long serialVersionUID = 20130825L;
	/** id */
	private Long funcId;
	/**功能編碼 */
	private String funcCode;
	/**功能描述 */
	private String funcDesc;

	public Function() {
		super();
	}

	public Function(Long funcId, String funcCode, String funcDesc) {
		super();
		this.funcId = funcId;
		this.funcCode = funcCode;
		this.funcDesc = funcDesc;
	}

	public String getFuncCode() {
		return funcCode;
	}

	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode;
	}

	public String getFuncDesc() {
		return funcDesc;
	}

	public void setFuncDesc(String funcDesc) {
		this.funcDesc = funcDesc;
	}

	public Long getFuncId() {
		return funcId;
	}

	public void setFuncId(Long funcId) {
		this.funcId = funcId;
	}

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((funcCode == null) ? 0 : funcCode.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Function other = (Function) obj;
        if (funcCode == null) {
            if (other.funcCode != null)
                return false;
        } else if (!funcCode.equals(other.funcCode))
            return false;
        return true;
    }
	
	
	
}
