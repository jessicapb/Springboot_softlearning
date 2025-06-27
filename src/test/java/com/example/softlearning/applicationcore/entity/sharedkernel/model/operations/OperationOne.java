package com.example.softlearning.applicationcore.entity.sharedkernel.model.operations;

import com.example.softlearning.applicationcore.entity.sharedkernel.model.operations.Operation;

public class OperationOne extends Operation{

    @Override
    public String getDetails() {
        return "OperationOne: Referencia: " + reference + ", Descripció: " + description + ", Data de començament: " + initDate + ", Data final" + finishDate+ "";
    }
    
}
