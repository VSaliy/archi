/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.ui.factory.elements;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

import com.archimatetool.editor.diagram.editparts.ArchimateElementEditPart;
import com.archimatetool.editor.diagram.figures.elements.CollaborationFigure;
import com.archimatetool.editor.ui.ColorFactory;
import com.archimatetool.editor.ui.IArchiImages;
import com.archimatetool.model.IArchimatePackage;



/**
 * Application Collaboration UI Provider
 * 
 * @author Phillip Beauvoir
 */
public class ApplicationCollaborationUIProvider extends AbstractArchimateElementUIProvider {

    @Override
    public EClass providerFor() {
        return IArchimatePackage.eINSTANCE.getApplicationCollaboration();
    }
    
    @Override
    public EditPart createEditPart() {
        return new ArchimateElementEditPart(CollaborationFigure.class);
    }

    @Override
    public String getDefaultName() {
        return Messages.ApplicationCollaborationUIProvider_0;
    }

    @Override
    public Image getImage() {
        return IArchiImages.ImageFactory.getImage(IArchiImages.ICON_APPLICATION_COLLABORATION);
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return IArchiImages.ImageFactory.getImageDescriptor(IArchiImages.ICON_APPLICATION_COLLABORATION);
    }
    
    @Override
    public Color getDefaultColor() {
        return ColorFactory.get(181, 255, 255);
    }
    
    @Override
    public boolean hasAlternateFigure() {
        return true;
    }
    
    @Override
    protected Dimension getDefaultSizeForFigureType(int figureType) {
        return figureType == 1 ? getDefaultSizeWithMinumumWidth(90) : super.getDefaultSizeForFigureType(figureType);
    }
}
