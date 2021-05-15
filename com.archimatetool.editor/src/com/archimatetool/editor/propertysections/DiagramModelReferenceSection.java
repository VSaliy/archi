/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.propertysections;

import com.archimatetool.model.IDiagramModelReference;



/**
 * Property Section for a Diagram Model Reference
 * 
 * @author Phillip Beauvoir
 */
public class DiagramModelReferenceSection extends AbstractNameDocumentationSection {
    
    /**
     * Filter to show or reject this section depending on input value
     */
    public static class Filter extends ObjectFilter {
        @Override
        public boolean isRequiredType(Object object) {
            return object instanceof IDiagramModelReference;
        }

        @Override
        public Class<?> getAdaptableType() {
            return IDiagramModelReference.class;
        }
        
        @Override
        public Object adaptObject(Object object) {
            // Return the referenced diagram model
            Object adapted = super.adaptObject(object);
            return adapted == null ? null : ((IDiagramModelReference)adapted).getReferencedModel();
        }
    }

    @Override
    protected IObjectFilter getFilter() {
        return new Filter();
    }
}
