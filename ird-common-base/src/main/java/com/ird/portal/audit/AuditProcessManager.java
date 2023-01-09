package com.ird.portal.audit;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.hibernate.Transaction;
import org.hibernate.action.spi.AfterTransactionCompletionProcess;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.event.spi.EventSource;

public class AuditProcessManager {
    
    private final Map<Transaction, AuditProcess> auditProcessMap;
    
    private static AuditProcessManager instance = null;
    
    public static AuditProcessManager getInstance() {
        if (instance == null) {
            instance = new AuditProcessManager();
        }
        return instance;
    }
    
    public AuditProcessManager() {
        auditProcessMap = new ConcurrentHashMap<Transaction, AuditProcess>();
    }
    
    public AuditProcess registerProcess(EventSource source) {
        Transaction transaction = source.getTransaction();
        AuditProcess auditProcess = auditProcessMap.get(transaction);
        if (auditProcess == null) {
            // No worries about registering a transaction twice - a transaction is single thread
            auditProcess = new AuditProcess();
            auditProcessMap.put(transaction, auditProcess);
            
            source.getActionQueue().registerProcess(auditProcess);
            
            source.getActionQueue().registerProcess(new AfterTransactionCompletionProcess() {
                
                public void doAfterTransactionCompletion(boolean success, SessionImplementor session) {
                    auditProcessMap.remove(transaction);
                }
            });
        }
        
        return auditProcess;
    }
    
}
