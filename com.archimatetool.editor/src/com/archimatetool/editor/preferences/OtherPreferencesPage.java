/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.preferences;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.PreferenceLinkArea;
import org.eclipse.ui.preferences.IWorkbenchPreferenceContainer;

import com.archimatetool.editor.ArchiPlugin;


/**
 * Other Preferences Page
 * 
 * Used as a top level replacement for Eclipse's "General" page (org.eclipse.ui.preferencePages.Workbench)
 * 
 * @author Phillip Beauvoir
 */
public class OtherPreferencesPage
extends PreferencePage
implements IWorkbenchPreferencePage {
    
    private static String HELP_ID = "com.archimatetool.help.prefsOther"; //$NON-NLS-1$
    
	public OtherPreferencesPage() {
		setPreferenceStore(ArchiPlugin.PREFERENCES);
		setDescription("Network and Security Preferences"); //$NON-NLS-1$
	}
	
    @Override
    protected Control createContents(Composite parent) {
        // Help
        PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, HELP_ID);
        
        Composite pageArea = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        pageArea.setLayout(layout);

        PreferenceLinkArea storageLinkArea1 = new PreferenceLinkArea(pageArea, SWT.NONE,
                "org.eclipse.ui.net.NetPreferences", //$NON-NLS-1$
                "Go to the <a>''{0}''</a> page.", //$NON-NLS-1$
                (IWorkbenchPreferenceContainer) getContainer(), null);
        storageLinkArea1.getControl().setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));
        
        PreferenceLinkArea storageLinkArea2 = new PreferenceLinkArea(pageArea, SWT.NONE,
                //"org.eclipse.equinox.security.ui.category", //$NON-NLS-1$
                "org.eclipse.equinox.security.ui.storage", //$NON-NLS-1$
                "Go to the <a>''{0}''</a> page.", //$NON-NLS-1$
                (IWorkbenchPreferenceContainer) getContainer(), null);
        storageLinkArea2.getControl().setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));

        Dialog.applyDialogFont(pageArea);
        
        return pageArea;
    }

    @Override
    public void init(IWorkbench workbench) {
        noDefaultAndApplyButton();
    }
    
}