/*******************************************************************************
 * Copyright (c) 2010 Bolton University, UK.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 *******************************************************************************/
package uk.ac.bolton.archimate.editor.diagram;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.ui.actions.ActionBarContributor;
import org.eclipse.gef.ui.actions.AlignmentRetargetAction;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.MatchHeightRetargetAction;
import org.eclipse.gef.ui.actions.MatchWidthRetargetAction;
import org.eclipse.gef.ui.actions.ZoomComboContributionItem;
import org.eclipse.gef.ui.actions.ZoomInRetargetAction;
import org.eclipse.gef.ui.actions.ZoomOutRetargetAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.RetargetAction;

import uk.ac.bolton.archimate.editor.actions.ArchimateEditorActionFactory;
import uk.ac.bolton.archimate.editor.diagram.actions.BringForwardAction;
import uk.ac.bolton.archimate.editor.diagram.actions.BringToFrontAction;
import uk.ac.bolton.archimate.editor.diagram.actions.ConnectionLineColorAction;
import uk.ac.bolton.archimate.editor.diagram.actions.ConnectionLineWidthAction;
import uk.ac.bolton.archimate.editor.diagram.actions.ConnectionRouterAction;
import uk.ac.bolton.archimate.editor.diagram.actions.DefaultEditPartSizeAction;
import uk.ac.bolton.archimate.editor.diagram.actions.ExportAsImageAction;
import uk.ac.bolton.archimate.editor.diagram.actions.ExportAsImageToClipboardAction;
import uk.ac.bolton.archimate.editor.diagram.actions.FillColorAction;
import uk.ac.bolton.archimate.editor.diagram.actions.FontAction;
import uk.ac.bolton.archimate.editor.diagram.actions.FontColorAction;
import uk.ac.bolton.archimate.editor.diagram.actions.FullScreenAction;
import uk.ac.bolton.archimate.editor.diagram.actions.SendBackwardAction;
import uk.ac.bolton.archimate.editor.diagram.actions.SendToBackAction;
import uk.ac.bolton.archimate.editor.diagram.actions.TextAlignmentAction;
import uk.ac.bolton.archimate.editor.ui.IArchimateImages;


/**
 * Action Bar contributor for Diagram Editor
 * 
 * @author Phillip Beauvoir
 */
public abstract class AbstractDiagramEditorActionBarContributor
extends ActionBarContributor {

    protected ZoomComboContributionItem fZoomCombo;
    
    @Override
    protected void buildActions() {
        // Zoom in and out
        addRetargetAction(new ZoomInRetargetAction());
        addRetargetAction(new ZoomOutRetargetAction());
        
        // Alignment Actions
        addRetargetAction(new AlignmentRetargetAction(PositionConstants.LEFT));
        addRetargetAction(new AlignmentRetargetAction(PositionConstants.CENTER));
        addRetargetAction(new AlignmentRetargetAction(PositionConstants.RIGHT));
        addRetargetAction(new AlignmentRetargetAction(PositionConstants.TOP));
        addRetargetAction(new AlignmentRetargetAction(PositionConstants.MIDDLE));
        addRetargetAction(new AlignmentRetargetAction(PositionConstants.BOTTOM));
        
        // Match width/height
        addRetargetAction(new MatchWidthRetargetAction());
        addRetargetAction(new MatchHeightRetargetAction());
        
        addRetargetAction(new RetargetAction(SnapToGrid.PROPERTY_GRID_ENABLED, 
                "Snap to Grid", IAction.AS_CHECK_BOX));

        addRetargetAction(new RetargetAction(GEFActionConstants.TOGGLE_GRID_VISIBILITY, 
                "Grid Visible", IAction.AS_CHECK_BOX));
        
        addRetargetAction(new RetargetAction(GEFActionConstants.TOGGLE_SNAP_TO_GEOMETRY, 
                "Snap to Alignment Guides", IAction.AS_CHECK_BOX));
        
        //addRetargetAction(new RetargetAction(GEFActionConstants.TOGGLE_RULER_VISIBILITY, 
        //        "Ruler", IAction.AS_CHECK_BOX));
        
        // Default Size
        RetargetAction retargetAction = new RetargetAction(DefaultEditPartSizeAction.ID, DefaultEditPartSizeAction.TEXT);
        retargetAction.setImageDescriptor(IArchimateImages.ImageFactory.getImageDescriptor(IArchimateImages.ICON_DEFAULT_SIZE));
        addRetargetAction(retargetAction);
        
        // Export as Image
        addRetargetAction(new RetargetAction(ExportAsImageAction.ID, ExportAsImageAction.TEXT));
        
        // Export as Image to Clipboard
        retargetAction = new RetargetAction(ExportAsImageToClipboardAction.ID, ExportAsImageToClipboardAction.TEXT);
        retargetAction.setActionDefinitionId(ExportAsImageToClipboardAction.ID); // key binding
        addRetargetAction(retargetAction);
        
        // Fill color, line width, font, color
        addRetargetAction(new RetargetAction(FillColorAction.ID, FillColorAction.TEXT));
        addRetargetAction(new RetargetAction(ConnectionLineWidthAction.ID, ConnectionLineWidthAction.TEXT));
        addRetargetAction(new RetargetAction(ConnectionLineColorAction.ID, ConnectionLineColorAction.TEXT));
        addRetargetAction(new RetargetAction(FontAction.ID, FontAction.TEXT));
        addRetargetAction(new RetargetAction(FontColorAction.ID, FontColorAction.TEXT));
        
        // Text Alignments
        retargetAction = new RetargetAction(TextAlignmentAction.ACTION_LEFT_ID, TextAlignmentAction.ACTION_LEFT_TEXT);
        retargetAction.setImageDescriptor(IArchimateImages.ImageFactory.getImageDescriptor(IArchimateImages.ICON_ALIGN_TEXT_LEFT));
        addRetargetAction(retargetAction);
   
        retargetAction = new RetargetAction(TextAlignmentAction.ACTION_CENTER_ID, TextAlignmentAction.ACTION_CENTER_TEXT);
        retargetAction.setImageDescriptor(IArchimateImages.ImageFactory.getImageDescriptor(IArchimateImages.ICON_ALIGN_TEXT_CENTER));
        addRetargetAction(retargetAction);

        retargetAction = new RetargetAction(TextAlignmentAction.ACTION_RIGHT_ID, TextAlignmentAction.ACTION_RIGHT_TEXT);
        retargetAction.setImageDescriptor(IArchimateImages.ImageFactory.getImageDescriptor(IArchimateImages.ICON_ALIGN_TEXT_RIGHT));
        addRetargetAction(retargetAction);

        // Order Actions
        addRetargetAction(new RetargetAction(BringToFrontAction.ID, BringToFrontAction.TEXT));
        addRetargetAction(new RetargetAction(BringForwardAction.ID, BringForwardAction.TEXT));
        addRetargetAction(new RetargetAction(SendToBackAction.ID, SendToBackAction.TEXT));
        addRetargetAction(new RetargetAction(SendBackwardAction.ID, SendBackwardAction.TEXT));
        
        // Connection Routers
        addRetargetAction(new RetargetAction(ConnectionRouterAction.BendPointConnectionRouterAction.ID,
                ConnectionRouterAction.CONNECTION_ROUTER_BENDPONT, IAction.AS_RADIO_BUTTON));
        addRetargetAction(new RetargetAction(ConnectionRouterAction.ShortestPathConnectionRouterAction.ID,
                ConnectionRouterAction.CONNECTION_ROUTER_SHORTEST_PATH, IAction.AS_RADIO_BUTTON));
        addRetargetAction(new RetargetAction(ConnectionRouterAction.ManhattanConnectionRouterAction.ID,
                ConnectionRouterAction.CONNECTION_ROUTER_MANHATTAN, IAction.AS_RADIO_BUTTON));
        
        // Full Screen
        retargetAction = new RetargetAction(FullScreenAction.ID, FullScreenAction.TEXT);
        retargetAction.setActionDefinitionId(FullScreenAction.ID);
        addRetargetAction(retargetAction);
    }

    @Override
    protected void declareGlobalActionKeys() {
        addGlobalActionKey(ActionFactory.DELETE.getId());
        addGlobalActionKey(ActionFactory.CUT.getId());
        addGlobalActionKey(ActionFactory.COPY.getId());
        addGlobalActionKey(ActionFactory.PASTE.getId());
        addGlobalActionKey(ActionFactory.UNDO.getId());
        addGlobalActionKey(ActionFactory.REDO.getId());
        addGlobalActionKey(ActionFactory.SELECT_ALL.getId());
        addGlobalActionKey(ActionFactory.PRINT.getId());
        addGlobalActionKey(ActionFactory.PROPERTIES.getId());
        addGlobalActionKey(ActionFactory.RENAME.getId());
    }

    @Override
    public void contributeToMenu(IMenuManager menuManager) {
        createViewMenu(menuManager);
        
        IMenuManager windowMenu = (IMenuManager)menuManager.find(IWorkbenchActionConstants.M_WINDOW);
        windowMenu.insertAfter(IWorkbenchActionConstants.MB_ADDITIONS, getAction(FullScreenAction.ID));
    }
    
    /**
     * Create the "View" Menu
     * @param menuManager
     */
    protected IMenuManager createViewMenu(IMenuManager menuManager) {
        IMenuManager viewMenu = new MenuManager("&View");
        
        viewMenu.add(getAction(GEFActionConstants.ZOOM_IN));
        viewMenu.add(getAction(GEFActionConstants.ZOOM_OUT));
        viewMenu.add(new Separator());
        
        viewMenu.add(getAction(SnapToGrid.PROPERTY_GRID_ENABLED));
        viewMenu.add(getAction(GEFActionConstants.TOGGLE_GRID_VISIBILITY));
        viewMenu.add(getAction(GEFActionConstants.TOGGLE_SNAP_TO_GEOMETRY));
        //viewMenu.add(getAction(GEFActionConstants.TOGGLE_RULER_VISIBILITY));
        viewMenu.add(new Separator());
        
        IMenuManager orderMenu = new MenuManager("Order");
        viewMenu.add(orderMenu);
        orderMenu.add(getAction(BringToFrontAction.ID));
        orderMenu.add(getAction(BringForwardAction.ID));
        orderMenu.add(getAction(SendToBackAction.ID));
        orderMenu.add(getAction(SendBackwardAction.ID));
        
        IMenuManager alignmentMenu = new MenuManager("Position");
        viewMenu.add(alignmentMenu);
        alignmentMenu.add(getAction(GEFActionConstants.ALIGN_LEFT));
        alignmentMenu.add(getAction(GEFActionConstants.ALIGN_CENTER));
        alignmentMenu.add(getAction(GEFActionConstants.ALIGN_RIGHT));
        alignmentMenu.add(new Separator());
        
        alignmentMenu.add(getAction(GEFActionConstants.ALIGN_TOP));
        alignmentMenu.add(getAction(GEFActionConstants.ALIGN_MIDDLE));
        alignmentMenu.add(getAction(GEFActionConstants.ALIGN_BOTTOM));
        alignmentMenu.add(new Separator());
        
        alignmentMenu.add(getAction(GEFActionConstants.MATCH_WIDTH));
        alignmentMenu.add(getAction(GEFActionConstants.MATCH_HEIGHT));
        alignmentMenu.add(getAction(DefaultEditPartSizeAction.ID));

        viewMenu.add(new Separator());
        
        IMenuManager connectionMenu = new MenuManager("Connection Router");
        viewMenu.add(connectionMenu);
        connectionMenu.add(getAction(ConnectionRouterAction.BendPointConnectionRouterAction.ID));
        connectionMenu.add(getAction(ConnectionRouterAction.ShortestPathConnectionRouterAction.ID));
        connectionMenu.add(getAction(ConnectionRouterAction.ManhattanConnectionRouterAction.ID));
        viewMenu.add(new Separator());
        
        menuManager.insertAfter(IWorkbenchActionConstants.M_EDIT, viewMenu);
        
        // IMenuManager fileMenu = menuManager.findMenuUsingPath(IWorkbenchActionConstants.M_FILE);

        // Export menu items
        IMenuManager exportMenu = menuManager.findMenuUsingPath(IWorkbenchActionConstants.M_FILE + "/export_menu");
        exportMenu.add(getAction(ExportAsImageAction.ID));
        exportMenu.add(getAction(ExportAsImageToClipboardAction.ID));
        
        IMenuManager editMenu = (IMenuManager)menuManager.find(IWorkbenchActionConstants.M_EDIT);
        String groupName = "group1_start";
        editMenu.insertAfter(ArchimateEditorActionFactory.RENAME.getId(), new Separator(groupName));
        
        // Fill Color Action
        editMenu.appendToGroup(groupName, getAction(FillColorAction.ID));
        
        // Connection Line Width and Color
        editMenu.appendToGroup(groupName, getAction(ConnectionLineWidthAction.ID));
        editMenu.appendToGroup(groupName, getAction(ConnectionLineColorAction.ID));

        // Font
        editMenu.appendToGroup(groupName, getAction(FontAction.ID));
        editMenu.appendToGroup(groupName, getAction(FontColorAction.ID));
        
        // Text Alignment
        IMenuManager textAlignmentMenu = new MenuManager("Text alignment");
        textAlignmentMenu.add(getAction(TextAlignmentAction.ACTION_LEFT_ID));
        textAlignmentMenu.add(getAction(TextAlignmentAction.ACTION_CENTER_ID));
        textAlignmentMenu.add(getAction(TextAlignmentAction.ACTION_RIGHT_ID));
        editMenu.appendToGroup(groupName, textAlignmentMenu);
        
        return viewMenu;
    }
    
    @Override
    public void contributeToToolBar(IToolBarManager toolBarManager) {
        // Add the Zoom Manager Combo
        fZoomCombo = new ZoomComboContributionItem(getPage());
        toolBarManager.add(fZoomCombo);

        toolBarManager.add(new Separator());
        toolBarManager.add(getAction(GEFActionConstants.ALIGN_LEFT));
        toolBarManager.add(getAction(GEFActionConstants.ALIGN_CENTER));
        toolBarManager.add(getAction(GEFActionConstants.ALIGN_RIGHT));
        toolBarManager.add(new Separator());
        toolBarManager.add(getAction(GEFActionConstants.ALIGN_TOP));
        toolBarManager.add(getAction(GEFActionConstants.ALIGN_MIDDLE));
        toolBarManager.add(getAction(GEFActionConstants.ALIGN_BOTTOM));
        toolBarManager.add(new Separator());   
        toolBarManager.add(getAction(GEFActionConstants.MATCH_WIDTH));
        toolBarManager.add(getAction(GEFActionConstants.MATCH_HEIGHT));
        toolBarManager.add(getAction(DefaultEditPartSizeAction.ID));
    }

}
