package pe.edu.upeu.appturismo202501.ui.presentation.componentsA

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextOverflow

data class ActivityBanner(
    @DrawableRes val image: Int,
    val city: String
)

// --------------------------------------------------
// 2. ActivityCard con Gradient + Text encima de la imagen
// --------------------------------------------------
@Composable
fun ActivityCard(
    item: ActivityBanner,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .width(180.dp)
            .height(220.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {             // ← fillMaxSize en lugar de matchParentSize

            // 1️⃣ Imagen de fondo
            Image(
                painter = painterResource(item.image),
                contentDescription = item.city,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()            // ← idem aquí
            )

            // 2️⃣ Degradado
            Box(
                modifier = Modifier
                    .fillMaxSize()                           // ← idem aquí
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color(0xCC000000)
                            ),
                            startY = 0f
                        )
                    )
            )

            // 3️⃣ Texto
            Text(
                text = item.city,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(12.dp)
            )
        }
    }
}


// --------------------------------------------------
// 3. ActivitiesSection (igual que antes)
// --------------------------------------------------
@Composable
fun ActivitiesSection(
    title: String,
    items: List<ActivityBanner>,
    modifier: Modifier = Modifier,
    onItemClick: (ActivityBanner) -> Unit = {}
) {
    Column(modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 12.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(items) { banner ->
                ActivityCard(
                    item = banner,
                    onClick = { onItemClick(banner) }
                )
            }
        }
    }
}