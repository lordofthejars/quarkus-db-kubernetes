package org.acme;

import java.util.Collections;
import java.util.List;

import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

public class ListDevelopersFallback implements FallbackHandler<List<Developer>> {

    @Override
    public List<Developer> handle(ExecutionContext context) {
        return Collections.emptyList();
    }
    
}
