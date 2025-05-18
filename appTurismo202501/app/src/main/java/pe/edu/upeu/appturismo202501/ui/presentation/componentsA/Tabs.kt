package pe.edu.upeu.appturismo202501.ui.presentation.componentsA

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.rememberAsyncImagePainter
import pe.edu.upeu.appturismo202501.modelo.CategoryResp

data class Category(
    val icon: ImageVector,
    val label: String
)



@Composable
fun CategoryTabs(
    categories: List<CategoryResp>,
    modifier: Modifier = Modifier,
    onSelected: (Int) -> Unit = {}
) {
    var selected by rememberSaveable { mutableStateOf(0) }

    val dividerColor = MaterialTheme.colorScheme.onSurface.copy(alpha = .15f)

    ScrollableTabRow(
        selectedTabIndex = selected,
        containerColor = Color.Transparent,
        edgePadding = 15.dp,
        indicator = {},
        divider = {
            Divider(color = dividerColor, thickness = 1.dp)
        },
        modifier = modifier
    ) {
        categories.forEachIndexed { index, cat ->

            val isSel = index == selected

            Tab(
                selected = isSel,
                onClick = {
                    selected = index
                    onSelected(index)
                },
                selectedContentColor = MaterialTheme.colorScheme.primary,
                unselectedContentColor = Color.White,
            ) {
                Surface(
                    color = if (isSel) Color.White else Color.Transparent,
                    shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
                    tonalElevation = if (isSel) 2.dp else 0.dp,
                    shadowElevation = if (isSel) 4.dp else 0.dp,
                ) {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Si el ícono es una URL, usa Coil para cargarlo
                        if (cat.icono != null) {
                            Image(
                                painter = rememberAsyncImagePainter(cat.icono),
                                contentDescription = cat.nombre,
                                modifier = Modifier.size(24.dp),
                                contentScale = ContentScale.Crop
                            )
                        }

                        Text(
                            cat.nombre,
                            fontSize = 15.sp,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = if (isSel) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                }
            }
        }
    }
}