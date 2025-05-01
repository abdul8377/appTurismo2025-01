package pe.edu.upeu.sysventasjpc.ui.presentation.components;

/**
 * Represents the state of a Floating Action Button (FAB), which can be either Collapsed or Expanded.
 * The FAB state is used to determine its visibility and behavior, such as showing or hiding sub-items.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0006\u0007B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0000\u0082\u0001\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lpe/edu/upeu/sysventasjpc/ui/presentation/components/FabButtonState;", "", "()V", "isExpanded", "", "toggleValue", "Collapsed", "Expand", "Lpe/edu/upeu/sysventasjpc/ui/presentation/components/FabButtonState$Collapsed;", "Lpe/edu/upeu/sysventasjpc/ui/presentation/components/FabButtonState$Expand;", "app_debug"})
public abstract class FabButtonState {
    
    private FabButtonState() {
        super();
    }
    
    public final boolean isExpanded() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final pe.edu.upeu.sysventasjpc.ui.presentation.components.FabButtonState toggleValue() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lpe/edu/upeu/sysventasjpc/ui/presentation/components/FabButtonState$Collapsed;", "Lpe/edu/upeu/sysventasjpc/ui/presentation/components/FabButtonState;", "()V", "app_debug"})
    public static final class Collapsed extends pe.edu.upeu.sysventasjpc.ui.presentation.components.FabButtonState {
        @org.jetbrains.annotations.NotNull()
        public static final pe.edu.upeu.sysventasjpc.ui.presentation.components.FabButtonState.Collapsed INSTANCE = null;
        
        private Collapsed() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lpe/edu/upeu/sysventasjpc/ui/presentation/components/FabButtonState$Expand;", "Lpe/edu/upeu/sysventasjpc/ui/presentation/components/FabButtonState;", "()V", "app_debug"})
    public static final class Expand extends pe.edu.upeu.sysventasjpc.ui.presentation.components.FabButtonState {
        @org.jetbrains.annotations.NotNull()
        public static final pe.edu.upeu.sysventasjpc.ui.presentation.components.FabButtonState.Expand INSTANCE = null;
        
        private Expand() {
        }
    }
}