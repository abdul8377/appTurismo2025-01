package pe.edu.upeu.appturismo202501.ui.presentation.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material.icons.outlined.DirectionsRun
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Museum
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Terrain
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import pe.edu.upeu.appturismo202501.R
import pe.edu.upeu.appturismo202501.ui.navigation.Destinations
import pe.edu.upeu.appturismo202501.ui.presentation.componentsA.ActivitiesSection
import pe.edu.upeu.appturismo202501.ui.presentation.componentsA.ActivityBanner
import pe.edu.upeu.appturismo202501.ui.presentation.componentsA.Category
import pe.edu.upeu.appturismo202501.ui.presentation.componentsA.CategoryTabs
import pe.edu.upeu.appturismo202501.ui.presentation.componentsA.CulturalBanner
import pe.edu.upeu.appturismo202501.ui.presentation.componentsA.CulturalSpacesSection
import pe.edu.upeu.appturismo202501.ui.presentation.componentsA.Experience
import pe.edu.upeu.appturismo202501.ui.presentation.componentsA.ExperiencesSection
import pe.edu.upeu.appturismo202501.ui.presentation.componentsA.NavItem
import pe.edu.upeu.appturismo202501.ui.presentation.componentsA.SimpleSearchBar
import pe.edu.upeu.appturismo202501.ui.theme.AppTurismo202501Theme
import pe.edu.upeu.appturismo202501.ui.theme.LightGreenColors
import pe.edu.upeu.appturismo202501.ui.presentation.componentsA.TurismoNavigationBar
import pe.edu.upeu.appturismo202501.ui.presentation.screens.welcome.viewModel.CategoryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(navController: NavController, viewModel: CategoryViewModel = hiltViewModel()) {

    val categories by viewModel.categories.collectAsState()
    val bg = painterResource(id = R.drawable.bg)

    Scaffold(
        bottomBar = {
            var selectedIndex by remember { mutableStateOf(0) }
            val navItems = listOf(
                NavItem("Explorar", Icons.Filled.Place, Icons.Outlined.Place),
                NavItem("Favoritos",   Icons.Filled.Favorite, Icons.Outlined.Favorite),
                NavItem("Carrito",   Icons.Filled.ShoppingCart, Icons.Outlined.ShoppingCart),
                NavItem("Reservas", Icons.Filled.Favorite, Icons.Outlined.FavoriteBorder),
                NavItem("Perfil",   Icons.Filled.AccountCircle, Icons.Outlined.AccountCircle)
            )
            var sel by remember { mutableStateOf(0) }
            TurismoNavigationBar(
                items = navItems,
                selectedIndex = selectedIndex,
                onItemSelected = { index ->
                    selectedIndex = index
                    when (navItems[index].label) {
                        "Perfil" -> navController.navigate(Destinations.Login.route)
                    }
                }
            )
        }) { padding ->

        /* ---------- CONTENEDOR PRINCIPAL ---------- */
        Box(
            Modifier
                .fillMaxSize()
                .padding(bottom = padding.calculateBottomPadding())) {

            /* ---- Bloque columna con imagen + textos ---- */
            LazyColumn {
                // imagen de cabecera
                item {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height((LocalConfiguration.current.screenHeightDp * 0.65f).dp)
                    ) {
                        Image(
                            painter = bg,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        /* textos sobre la imagen */
                        Column(
                            Modifier
                                .align(Alignment.BottomStart)
                                .padding(16.dp)
                        ) {
                            Text(
                                "Recuerdos de viaje que\nnunca olvidarás",
                                color = Color.White,
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(Modifier.height(8.dp))
                            Text("Originals by GetYourGuide", color = Color.White.copy(alpha = .8f))
                            Text(
                                "Paseo en globo al amanecer en Göreme",
                                color = Color.White.copy(alpha = .8f)
                            )
                            Text(
                                "Más información >",
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(Modifier.height(66.dp))

                        }
                        //  pestañas sobre la parte baja de la imagen

                        CategoryTabs(
                            categories = categories,
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .fillMaxWidth(),
                            onSelected = { idx ->
                                println("Categoría seleccionada: ${categories[idx].nombre}")
                            }
                        )
                    }
                }

                item {


                    val culturalExperiences = listOf(
                        Experience(R.drawable.ic_launcher_background, "TICKET DE ENTRADA",
                            "San Diego Ticket de entrada al Museo USS Midway",
                            "1 día • Sin colas • Audioguía opcional", 4.9, 3204, "39 USD"),
                        Experience(R.drawable.ic_launcher_background, "EXCURSIÓN DE UN DÍA",
                            "Las Vegas: Gran Cañón y Presa Hoover, Ópalo",
                            "10 horas • Sin colas • Comidas incl.", 4.7, 2105, "99 USD"),
                        // …más
                    )

                    ExperiencesSection(
                        title = "Experiencias culturales inolvidables",
                        experiences = culturalExperiences
                    )
                }

                val sample = listOf(
                    CulturalBanner(R.drawable.ic_launcher_background,  "USS Midway Museum",    "46 actividades"),
                    CulturalBanner(R.drawable.ic_launcher_background,  "Estatua de la Libertad","164 actividades")
                )

                item {
                    CulturalSpacesSection(
                        title = "Espacios culturales que no te puedes perder",
                        items = sample,
                        topPadding = 8.dp,      // separa un poco del bloque anterior
                        bottomPadding = 12.dp   // separa del LazyRow
                    )
                }

                val worldActivities = listOf(
                    ActivityBanner(R.drawable.ic_launcher_background , "Las Vegas"),
                    ActivityBanner(R.drawable.ic_launcher_background , "San Francisco"),
                    ActivityBanner(R.drawable.ic_launcher_background      , "Roma")
                )

                item {
                    ActivitiesSection(
                        title = "Actividades culturales impresionantes por todo el mundo",
                        items = worldActivities
                    )
                }




            }

            /* ---------- BUSCADOR FLOTANTE ---------- */
            SimpleSearchBar(
                onClick = { navController.navigate("search") },
                modifier = Modifier
                    //.align(Alignment.TopCenter)   // encima del resto
                    .align(Alignment.TopCenter)
                    .padding(top = 35.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth()
                    .padding(top = 16.dp)         // distancia al borde
                    .zIndex(1f)                   // garantiza prioridad de dibujo
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WelcomeScreenPreview() {
    val navController = rememberNavController()          // ← NavController “falso” para previews
    AppTurismo202501Theme(colorScheme = LightGreenColors) {
        WelcomeScreen(navController = navController)
    }
}
