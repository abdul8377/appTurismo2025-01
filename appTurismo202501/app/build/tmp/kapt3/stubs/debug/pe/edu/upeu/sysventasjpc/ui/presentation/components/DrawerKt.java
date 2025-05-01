package pe.edu.upeu.sysventasjpc.ui.presentation.components;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007\u001a,\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0010H\u0007\u00a8\u0006\u0011"}, d2 = {"Drawer", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "scaffoldState", "Landroidx/compose/material3/DrawerState;", "navController", "Landroidx/navigation/NavHostController;", "items", "", "Lpe/edu/upeu/appturismo202501/ui/navigation/Destinations;", "DrawerItem", "item", "selected", "", "onItemClick", "Lkotlin/Function1;", "app_debug"})
public final class DrawerKt {
    
    @androidx.compose.runtime.Composable()
    public static final void DrawerItem(@org.jetbrains.annotations.NotNull()
    pe.edu.upeu.appturismo202501.ui.navigation.Destinations item, boolean selected, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super pe.edu.upeu.appturismo202501.ui.navigation.Destinations, kotlin.Unit> onItemClick) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void Drawer(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope scope, @org.jetbrains.annotations.NotNull()
    androidx.compose.material3.DrawerState scaffoldState, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavHostController navController, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends pe.edu.upeu.appturismo202501.ui.navigation.Destinations> items) {
    }
}