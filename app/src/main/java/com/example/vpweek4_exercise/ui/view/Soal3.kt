package com.example.vpweek4_exercise.ui.view

import android.annotation.SuppressLint
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vpweek4_exercise.R
import com.example.vpweek4_exercise.data.DataSource
import com.example.vpweek4_exercise.model.Feed
import com.example.vpweek4_exercise.model.Story
import com.example.vpweek4_exercise.model.Suggestion
import kotlinx.coroutines.launch
import java.text.DateFormat
import java.text.NumberFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Soal3View(story: List<Story>, feed: List<Feed>, suggestion: List<Suggestion>) {
    val context = LocalContext.current
    var index = 0

    Scaffold(
        content = {
            LazyColumn(modifier = Modifier.padding(bottom = 50.dp)) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 14.dp, horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo_dropdown),
                            contentDescription = "Logo Dropdown",
                        )

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(15.dp)
                        ) {
                            IconButton(
                                onClick = {
                                    Toast
                                        .makeText(
                                            context,
                                            "Notification Button",
                                            Toast.LENGTH_SHORT
                                        )
                                        .show()
                                }
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.notification),
                                    contentDescription = "Notification",
                                    modifier = Modifier.size(30.dp)
                                )
                            }

                            IconButton(
                                onClick = {
                                    Toast
                                        .makeText(
                                            context,
                                            "Direct Message Button",
                                            Toast.LENGTH_SHORT
                                        )
                                        .show()
                                }
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.dm),
                                    contentDescription = "Direct Message",
                                    modifier = Modifier.size(30.dp)
                                )
                            }
                        }
                    }
                }

                item {
                    LazyRow {
                        items(story) {
                            InstaStory(it, modifier = Modifier.padding(bottom = 10.dp))
                        }
                    }
                }

                items(feed) {
                    Feed(it, modifier = Modifier.padding(top = 5.dp))

                    index++
                    if (index == 1 || index == 5 || index == 12) {
                        LazyRow {
                            items(suggestion) {
                                FriendSuggest(it)
                            }
                        }
                    }
                }
            }
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.height(40.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = {
                            Toast
                                .makeText(
                                    context,
                                    "Home Button",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.home),
                            contentDescription = "Home"
                        )
                    }

                    IconButton(
                        onClick = {
                            Toast
                                .makeText(
                                    context,
                                    "Search Button",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = "Search"
                        )
                    }

                    IconButton(
                        onClick = {
                            Toast
                                .makeText(
                                    context,
                                    "Upload",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.post),
                            contentDescription = "Post"
                        )
                    }

                    IconButton(onClick = {
                        Toast
                            .makeText(
                                context,
                                "Reels Button",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.reels),
                            contentDescription = "Reels"
                        )
                    }

                    IconButton(
                        onClick = {
                            Toast
                                .makeText(
                                    context,
                                    "Profile Button",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_profile_picture),
                            contentDescription = "Profile"
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun InstaStory(story: Story, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(start = 5.dp, end = 5.dp)
            .clickable {

                Toast
                    .makeText(
                        context, if (story.username.equals("Your Story"))
                            story.username else "${story.username} story",
                        Toast.LENGTH_SHORT
                    )
                    .show()
            }
    ) {
        Box(
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.story),
                contentDescription = "Story Border",
                modifier = Modifier.size(80.dp)
            )

            Image(
                painter = painterResource(id = getImageInt(story.profilePicture)),
                contentDescription = "Story Profile",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape),
            )
        }

        Text(text = story.username, fontSize = 12.sp)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Feed(feed: Feed, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var isLike by rememberSaveable { mutableStateOf(feed.isLike) }
    var isSaved by rememberSaveable { mutableStateOf(feed.isSaved) }
    var like by rememberSaveable { mutableStateOf(feed.like) }
    var isExpand by rememberSaveable { mutableStateOf(false) }

    Column(modifier = Modifier.padding(top = 5.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, top = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = getImageInt(image = feed.profilePicture)),
                        contentDescription = "Profile Photo",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                    )

                    Text(text = feed.username, modifier = Modifier.padding(start = 10.dp))
                }
            }

            Icon(
                painter = painterResource(id = R.drawable.more_vert),
                contentDescription = "More Vert"
            )
        }

        Image(
            painter = painterResource(id = getImageInt(image = feed.feedContent)),
            contentDescription = "Feed Content",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 5.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = {
                            Toast
                                .makeText(
                                    context,
                                    "Like Button",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                            if (isLike == false) isLike = true else isLike = false
                            if (isLike == true) like += 1 else like -= 1
                        }
                    ) {
                        if (isLike == true) {
                            Image(
                                painter = painterResource(id = R.drawable.liked),
                                contentDescription = "Like Button"
                            )
                        } else {
                            Icon(
                                painter = painterResource(id = R.drawable.like),
                                contentDescription = "Like Button"
                            )
                        }
                    }

                    IconButton(
                        onClick = {
                            Toast
                                .makeText(
                                    context,
                                    "Comment Button",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.comment),
                            contentDescription = "Comment Button",
                        )
                    }

                    IconButton(
                        onClick = {
                            Toast
                                .makeText(
                                    context,
                                    "Send Button",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.messanger),
                            contentDescription = "Send Button",
                            modifier = Modifier.padding(top = 2.dp)
                        )
                    }
                }
            }

            IconButton(
                onClick = {
                    Toast
                        .makeText(
                            context,
                            "Post Saved",
                            Toast.LENGTH_SHORT
                        )
                        .show()
                    if (isSaved == false) isSaved = true else isSaved = false
                }
            ) {
                if (isSaved == true) {
                    Icon(
                        painter = painterResource(id = R.drawable.saved_dark),
                        contentDescription = "Save Button",
                        modifier = Modifier.padding(end = 10.dp)
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.save),
                        contentDescription = "Save Button",
                        modifier = Modifier.padding(end = 10.dp)
                    )
                }
            }
        }

        if (feed.like > 1) {
            val formattedLikes = NumberFormat.getNumberInstance(Locale.getDefault()).format(like)

            Text(
                text = "${formattedLikes} Likes",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, top = 5.dp)
            )
        } else {
            Text(
                text = "${like} Like",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, top = 5.dp)
            )
        }

        Column(
            modifier = Modifier.clickable {
                if (isExpand == false) isExpand = true else isExpand = false
            }
        ) {
            if (isExpand == true) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append(feed.username)
                        }
                        append(" ${feed.caption}")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp),
                    textAlign = TextAlign.Justify
                )
            } else {
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append(feed.username)
                        }
                        append(" ${feed.caption}")
                    },
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp),
                )
            }
        }

        Text(
            text = formatDate(feed.date),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, bottom = 5.dp),
            fontSize = 10.sp
        )
    }
}

@Composable
fun FriendSuggest(suggestion: Suggestion, modifier: Modifier = Modifier) {
    var isFollowing by rememberSaveable { mutableStateOf(suggestion.isFollowing) }
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .padding(start = 15.dp, top = 10.dp, bottom = 10.dp)
            .border(2.dp, Color.LightGray, shape = RoundedCornerShape(15.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Close Icon",
            modifier = Modifier
                .size(28.dp)
                .align(Alignment.End)
                .padding(end = 10.dp, top = 10.dp)
        )

        Column(
            modifier = Modifier
                .padding(start = 10.dp, top = 0.dp, end = 10.dp, bottom = 10.dp)
                .offset(y = -10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = getImageInt(image = suggestion.profilePicture)),
                contentDescription = "Profile Photo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )

            Text(text = suggestion.username)

            Spacer(modifier = Modifier.height(5.dp))

            if (isFollowing == false) {
                Button(
                    onClick = {
                        Toast
                            .makeText(
                                context,
                                "Followed",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                        isFollowing = true
                    },
                    modifier = Modifier
                        .width(90.dp)
                        .height(35.dp),
                    colors = ButtonDefaults.buttonColors(Color.Blue)
                ) {
                    Text(text = "Follow", color = Color.White)
                }
            } else {
                Column(
                    modifier = Modifier
                        .clickable {
                            Toast
                                .makeText(
                                    context,
                                    "Unfollowed",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                            isFollowing = false
                        }
                ) {
                    Text(
                        text = "Following",
                        modifier = Modifier
                            .border(2.dp, Color.Blue, shape = RoundedCornerShape(25.dp))
                            .padding(start = 15.dp, end = 15.dp, top = 8.dp, bottom = 8.dp),
                        color = Color.Blue
                    )
                }
            }
        }
    }
}

@SuppressLint("DiscouragedApi")
@Composable
fun getImageInt(image: String): Int {
    val context = LocalContext.current

    val imageID = remember {
        context.resources.getIdentifier(image, "drawable", context.packageName)
    }
    return imageID
}

@RequiresApi(Build.VERSION_CODES.O)
fun formatDate(uploadDateString: String): String {
    val currentYear = Calendar.getInstance().get(Calendar.YEAR)

    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val uploadDate = dateFormat.parse(uploadDateString)

    val uploadCalendar = Calendar.getInstance()
    uploadCalendar.time = uploadDate

    val resultFormat = if (uploadCalendar.get(Calendar.YEAR) == currentYear) {
        SimpleDateFormat("MMMM d", Locale.getDefault())
    } else {
        SimpleDateFormat("MMMM d, yyyy", Locale.getDefault())
    }

    return resultFormat.format(uploadDate)
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Soal3Preview() {
    Soal3View(DataSource().loadStory(), DataSource().loadFeed(), DataSource().loadSuggestion())
}