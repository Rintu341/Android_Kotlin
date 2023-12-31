package com.example.shopinglistapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopinglistapp.Data.ShoppingListItemData
import com.example.shopinglistapp.model.ShoppingListItem

@Composable
fun ShoppingListApp() {
    var isOpenDialog by remember {
        mutableStateOf(false)
    }
    val obj by remember {
        mutableStateOf(ShoppingListItemData())
    }
    var itemName by remember {
        mutableStateOf("")
    }
    var itemQnt by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp)
    ) {

        Text(
            text = "ShoppingList App",
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(12.dp),
            fontFamily = FontFamily.Default,
            color = MaterialTheme.colorScheme.primary
        )
        LazyColumnUI(obj = obj)
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End,
        ) {
            FloatingActionButton(
                onClick = { isOpenDialog = !isOpenDialog },
                shape = RoundedCornerShape(30.dp),

                ) {
                IconButton(onClick = {isOpenDialog = isOpenDialog}) {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = "Add Item",
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }
        if (isOpenDialog) {
             AlertDialogUI(itemName,itemQnt,isOpenDialog,-1)
            /*
            AlertDialog(
                modifier = Modifier.padding(all = 8.dp),
                onDismissRequest = { isOpenDialog = false },
                title = { Text(text = "Add Shopping List Item") },
                confirmButton = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = itemName, onValueChange = { newitem -> itemName = newitem },
                            placeholder = { Text("item name") },
                            shape = RoundedCornerShape(20),
                            singleLine = true,
                        )
                        OutlinedTextField(
                            value = itemQnt, onValueChange = { newqnt -> itemQnt = newqnt },
                            placeholder = { Text("item Quantity") },
                            shape = RoundedCornerShape(20),
                            singleLine = true,
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Button(
                                onClick = { // Add new item to list
                                    if (!itemName.isEmpty()) {
                                        val objItem = ShoppingListItem(
                                            id = obj.shoppingData.size + 1,
                                            itemName = itemName,
                                            quantity = itemQnt.toInt()
                                        )
                                        obj.shoppingData += objItem
                                        isOpenDialog = !isOpenDialog
                                        itemName = ""; itemQnt = ""
                                    }
                                },
                            ) {
                                Text("Add")
                            }
                            Button(
                                onClick = { isOpenDialog = false; itemName = ""; itemQnt = "" },
                            ) {

                                Text("Cancel")
                            }
                        }
                    }
                },
            )
            */
        }

    }
}


//use Alert Dialog to add Shopping data
@Composable
fun AlertDialogUI(
    itemN: String,
    itemQ: String,
    var isOpenDialog: Boolean,
    id:Int
) {
    var openDialog by remember { mutableStateOf(isOpenDialog) } // Use a var with remember
    val obj by remember {
        mutableStateOf(ShoppingListItemData())
    }
    var itemName by remember {
        mutableStateOf(itemN)
    }
    var itemQnt by remember {
        mutableStateOf(itemQ)
    }
    if (openDialog) { // Conditionally render the dialog based on the state
        AlertDialog(
            modifier = Modifier.padding(all = 8.dp),
            onDismissRequest = { openDialog = false },
            title = { Text(text = "Add Shopping List Item") },
            confirmButton = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = itemName, onValueChange = {newitem -> itemName = newitem},
                        placeholder = { Text("item name") },
                        shape = RoundedCornerShape(20),
                        singleLine = true,
                    )
                    OutlinedTextField(
                        value = itemQnt, onValueChange = {newqnt -> itemQnt = newqnt},
                        placeholder = { Text("item Quantity") },
                        shape = RoundedCornerShape(20),
                        singleLine = true,
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            onClick = {
                                if (!itemName.isEmpty()){
                                    if(id == -1)
                                    {
                                        val objItem = ShoppingListItem(
                                            id = obj.shoppingData.size + 1,
                                            itemName = itemName,
                                            quantity = itemQnt.toInt()
                                        )
                                        obj.shoppingData += objItem
                                    }else
                                    {
                                        obj.modifyItemData(id,itemName,itemQnt)
                                    }
                                }
                            }
                        ) {
                            Text("Add")
                        }
                        Button(
                            onClick = { openDialog = false },
                        ) {
                            Text("Cancel")
                        }
                    }
                }
            }
        )
    }
    // Note: No return statement here as @Composable functions do not return values directly.
}
@Composable
fun LazyColumnUI(obj : ShoppingListItemData) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
            item()
            {
                for (x in obj.shoppingData)
                {
                    ItemUI(mylist = x)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
    }
}

@Composable
fun ItemUI(mylist : ShoppingListItem) {
    var isEdit by remember {
        mutableStateOf(false)
    }
    var isDelete by remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(2.dp, color = Color.Cyan)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "item: "+mylist.itemName)
            Text(text = "qnt: "+mylist.quantity)
            Row {
                IconButton(onClick = {
                    isEdit = !isEdit
                }) {
                    Icon(Icons.Filled.Create, contentDescription = "update")
                }
                IconButton(onClick = {
                    isDelete = !isDelete
                }) {
                    Icon(Icons.Filled.Delete, contentDescription = "Delete")
                }

            }
        }
    }
    if(isEdit)
    {
        AlertDialogUI(mylist.itemName,mylist.quantity.toString(),true,mylist.id)
    }
    if(isDelete)
    {
        val obj = ShoppingListItemData()
        obj.deleteItemData(mylist.id)
    }
}

@Preview(showBackground = true)
@Composable
fun ShoppingListAppPreview() {
    ShoppingListApp()
}