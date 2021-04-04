#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.plugin;

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.ui.IWorkbench
import org.eclipse.ui.IWorkbenchWindow
import org.eclipse.ui.PlatformUI

/**
 * Executed by click menu.<br></br>
 */
class SampleHandlerKt : AbstractHandler() {
    private val window: IWorkbenchWindow

    /**
     * {@inheritDoc}
     */
    @kotlin.Throws(ExecutionException::class)
    fun execute(event: ExecutionEvent?): Any? {
        MessageDialog.openInformation(window.getShell(), "Eclipse Plugin Archetype", "Hello, Maven+Eclipse world,\n \${parentArtifactId} is built with Tycho")
        return null
    }

    /**
     * constructor.
     */
    init {
        val workbench: IWorkbench = PlatformUI.getWorkbench()
        window = workbench.getActiveWorkbenchWindow()
    }
}