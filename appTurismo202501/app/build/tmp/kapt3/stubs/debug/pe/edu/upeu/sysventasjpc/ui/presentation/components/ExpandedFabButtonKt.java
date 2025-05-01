package pe.edu.upeu.sysventasjpc.ui.presentation.components;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001a\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a$\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u001a;\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u000e0\u0013H\u0007\u001a\u008a\u0001\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u001a2\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00072!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u000e0\u00132#\b\u0002\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u000e0\u0013H\u0007\u001a\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0007\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\""}, d2 = {"FabButtonMain", "Lpe/edu/upeu/sysventasjpc/ui/presentation/components/FabButtonMain;", "iconRes", "Landroidx/compose/ui/graphics/vector/ImageVector;", "iconRotate", "", "FabButtonSub", "Lpe/edu/upeu/sysventasjpc/ui/presentation/components/FabButtonSub;", "backgroundTint", "Landroidx/compose/ui/graphics/Color;", "iconTint", "FabButtonSub--OWjLjI", "(JJ)Lpe/edu/upeu/sysventasjpc/ui/presentation/components/FabButtonSub;", "MiniFabItem", "", "item", "Lpe/edu/upeu/sysventasjpc/ui/presentation/components/FabButtonItem;", "fabOption", "onFabItemClicked", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "MultiFloatingActionButton", "modifier", "Landroidx/compose/ui/Modifier;", "items", "", "fabState", "Landroidx/compose/runtime/MutableState;", "Lpe/edu/upeu/sysventasjpc/ui/presentation/components/FabButtonState;", "fabIcon", "fabItem", "stateChanged", "rememberMultiFabState", "app_debug"})
public final class ExpandedFabButtonKt {
    
    /**
     * Creates a new instance of [FabButtonMain] with the provided icon and optional rotation.
     *
     * @param iconRes The [ImageVector] representing the icon to be displayed on the main FAB.
     * @param iconRotate The optional rotation angle for the main FAB icon. If null, the icon will not be rotated.
     * @return A new instance of [FabButtonMain] with the specified icon and rotation.
     */
    @org.jetbrains.annotations.NotNull()
    public static final pe.edu.upeu.sysventasjpc.ui.presentation.components.FabButtonMain FabButtonMain(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.graphics.vector.ImageVector iconRes, float iconRotate) {
        return null;
    }
    
    /**
     * Remembers the state of a Multi-Floating Action Button (FAB) using [remember] and [mutableStateOf].
     *
     * @return A [MutableState] that holds the current state of the Multi-FAB.
     */
    @androidx.compose.runtime.Composable()
    @org.jetbrains.annotations.NotNull()
    public static final androidx.compose.runtime.MutableState<pe.edu.upeu.sysventasjpc.ui.presentation.components.FabButtonState> rememberMultiFabState() {
        return null;
    }
    
    /**
     * Composable function to display a Multi-Floating Action Button (Multi-FAB) that can be expanded to reveal sub-items.
     *
     * @param modifier The optional [Modifier] for customizing the layout of the Multi-FAB.
     * @param items The list of [FabButtonItem] representing the sub-items to be displayed when the Multi-FAB is expanded.
     * @param fabState The [MutableState] representing the current state of the Multi-FAB, whether it is expanded or collapsed.
     * @param fabIcon The [FabButtonMain] representing the main FAB with an icon and optional rotation.
     * @param fabOption The [FabButtonSub] representing the customization options for the sub-items.
     * @param onFabItemClicked The callback function to handle click events on the sub-items.
     * @param stateChanged The optional callback function to notify when the state of the Multi-FAB changes (expanded or collapsed).
     */
    @androidx.compose.runtime.Composable()
    public static final void MultiFloatingActionButton(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    java.util.List<pe.edu.upeu.sysventasjpc.ui.presentation.components.FabButtonItem> items, @org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<pe.edu.upeu.sysventasjpc.ui.presentation.components.FabButtonState> fabState, @org.jetbrains.annotations.NotNull()
    pe.edu.upeu.sysventasjpc.ui.presentation.components.FabButtonMain fabIcon, @org.jetbrains.annotations.NotNull()
    pe.edu.upeu.sysventasjpc.ui.presentation.components.FabButtonSub fabOption, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super pe.edu.upeu.sysventasjpc.ui.presentation.components.FabButtonItem, kotlin.Unit> onFabItemClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super pe.edu.upeu.sysventasjpc.ui.presentation.components.FabButtonState, kotlin.Unit> stateChanged) {
    }
    
    /**
     * Composable function to display an individual sub-item of the Multi-Floating Action Button (Multi-FAB).
     *
     * @param item The [FabButtonItem] representing the sub-item with an icon and label.
     * @param fabOption The [FabButtonSub] representing the customization options for the sub-items.
     * @param onFabItemClicked The callback function to handle click events on the sub-items.
     */
    @androidx.compose.runtime.Composable()
    public static final void MiniFabItem(@org.jetbrains.annotations.NotNull()
    pe.edu.upeu.sysventasjpc.ui.presentation.components.FabButtonItem item, @org.jetbrains.annotations.NotNull()
    pe.edu.upeu.sysventasjpc.ui.presentation.components.FabButtonSub fabOption, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super pe.edu.upeu.sysventasjpc.ui.presentation.components.FabButtonItem, kotlin.Unit> onFabItemClicked) {
    }
}