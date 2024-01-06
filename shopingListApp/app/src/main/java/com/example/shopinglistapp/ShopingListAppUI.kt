package com.example.shopinglistapp

<<<<<<< HEAD
=======
import android.util.Log
>>>>>>> dev
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
<<<<<<< HEAD
import androidx.compose.foundation.layout.Spacer
=======
>>>>>>> dev
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
<<<<<<< HEAD
import androidx.compose.foundation.lazy.LazyColumn
=======
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
>>>>>>> dev
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
<<<<<<< HEAD
=======
import androidx.compose.material3.ButtonDefaults
>>>>>>> dev
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
<<<<<<< HEAD
=======
import androidx.compose.material3.TextField
>>>>>>> dev
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
<<<<<<< HEAD
import com.example.shopinglistapp.Data.ShoppingListItemData
=======
>>>>>>> dev
import com.example.shopinglistapp.model.ShoppingListItem

@Composable
fun ShoppingListApp() {
    var isOpenDialog by remember {
        mutableStateOf(false)
    }
<<<<<<< HEAD
=======
    var shoppingData by remember {
        mutableStateOf(listOf<ShoppingListItem>())
    }
>>>>>>> dev
    var itemName by remember {
        mutableStateOf("")
    }
    var itemQnt by remember {
        mutableStateOf("")
    }
<<<<<<< HEAD
    val obj by remember {
        mutableStateOf(ShoppingListItemData())
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp)
=======

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 12.dp)
>>>>>>> dev
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
<<<<<<< HEAD
        LazyColumnUI(obj = obj)
        Row(
            modifier = Modifier
                .fillMaxSize()
=======
        LazyColumn(
            modifier = Modifier.fillMaxWidth(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(shoppingData)
            {item ->
                if(item.isEdit)
                {
                    ShoppingItemEditor(item = item, onEditComplete ={
                            itemName, itemQuantity ->
                        shoppingData = shoppingData.map { it.copy(isEdit = false) }
                        val itemItem = shoppingData.find { it.id == item.id }
                        itemItem?.let{
                            it.itemName = itemName
                            it.quantity = itemQuantity
                        }
                    } )
                    Log.d("Update","update")
                }else {
                    ItemUI(item,
                        onEditClick = {
                            shoppingData = shoppingData.map{it.copy(isEdit = it.id ==item.id)}
                        },
                        onDeleteClick = {
                            shoppingData = shoppingData - item
                        }
                    )
                    Log.d("Show","show")
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxSize(1f)
>>>>>>> dev
                .padding(8.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End,
        ) {
            FloatingActionButton(
                onClick = { isOpenDialog = !isOpenDialog },
                shape = RoundedCornerShape(30.dp),

                ) {
<<<<<<< HEAD
                IconButton(onClick = { isOpenDialog = !isOpenDialog }) {
=======
                IconButton(onClick = {isOpenDialog = !isOpenDialog}) {
>>>>>>> dev
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = "Add Item",
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }
<<<<<<< HEAD
        if (isOpenDialog) {/*
            isOpenDialog = AlertDialogUI(itemName,itemQnt,{newitem-> itemName = newitem},{newqnt->itemQnt = newqnt},isOpenDialog)
             */
=======
        if (isOpenDialog) {
>>>>>>> dev
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
<<<<<<< HEAD
                            value = itemName, onValueChange = { newitem -> itemName = newitem },
=======
                            value = itemName, onValueChange = { itemName = it },
>>>>>>> dev
                            placeholder = { Text("item name") },
                            shape = RoundedCornerShape(20),
                            singleLine = true,
                        )
                        OutlinedTextField(
<<<<<<< HEAD
                            value = itemQnt, onValueChange = { newqnt -> itemQnt = newqnt },
=======
                            value = itemQnt, onValueChange = {itemQnt = it },
>>>>>>> dev
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
<<<<<<< HEAD
                                    if (!itemName.isEmpty()) {
                                        val objItem = ShoppingListItem(
                                            id = obj.shoppingData.size + 1,
                                            itemName = itemName,
                                            quantity = itemQnt.toInt()
                                        )
                                        obj.shoppingData += objItem
=======
                                    if (itemName.isNotEmpty()) {
                                        val objItem = ShoppingListItem(
                                            id = shoppingData.size + 1,
                                            itemName = itemName,
                                            quantity = itemQnt.toIntOrNull()?:1
                                        )
                                        shoppingData += objItem
>>>>>>> dev
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
<<<<<<< HEAD
                },
=======
                }
>>>>>>> dev
            )
        }
    }
}

<<<<<<< HEAD
/*
//use Alert Dialog to add Shopping data
@Composable
fun AlertDialogUI(itemName:String,itemQnt:String,onItemChange: (String) -> Unit, onQntChange:(String)->Unit,openDialog: Boolean)
{
    var openDialog = isOpenDialog
    AlertDialog(
        modifier = Modifier.padding(all = 8.dp),
        onDismissRequest = { openDialog = false },
        title = {Text(text = "Add Shopping List Item" )},
        confirmButton = {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ){
                    OutlinedTextField(
                        value = itemName, onValueChange =onItemChange
                        , placeholder = {Text("item name")},
                        shape = RoundedCornerShape(20),
                        singleLine = true,
                    )
                    OutlinedTextField(
                        value = itemQnt, onValueChange = onQntChange
                        , placeholder = {Text("item Quantity")},
                        shape = RoundedCornerShape(20),
                        singleLine = true,
                    )
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Button(
                        onClick = { /*TODO*/ },
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
        },
    )
    return openDialog
}
 */
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
=======
@Composable
fun ShoppingItemEditor(item:ShoppingListItem,onEditComplete:(String,Int)->Unit)
{
    var itemName by remember{
        mutableStateOf(item.itemName)
    }
    var itemQuantity by remember {
        mutableStateOf(item.quantity.toString())
    }
    var isEditing by remember {
        mutableStateOf(item.isEdit)
    }
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column (
            modifier = Modifier.weight(3f)
        ){
            TextField(value = itemName,
                onValueChange ={itemName = it} ,
                singleLine =  true,

                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp),
            )
            TextField(value = itemQuantity,
                onValueChange ={itemQuantity = it} ,
                singleLine =  true,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp),
            )
        }
        Button(onClick = {
            isEditing = false
            onEditComplete(itemName,itemQuantity.toIntOrNull()?:1)
        },
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(Color.Blue)
        ) {
            Text(
                "Save",
            )
        }
>>>>>>> dev
    }
}

@Composable
<<<<<<< HEAD
fun ItemUI(mylist : ShoppingListItem) {
=======
fun ItemUI(myList : ShoppingListItem,onEditClick:()->Unit,onDeleteClick:()->Unit) {

>>>>>>> dev
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
<<<<<<< HEAD
            Text(text = "item: "+mylist.itemName)
            Text(text = "qnt: "+mylist.quantity)
            Row {
                IconButton(onClick = {
                    /*TODO*/
=======
            Text(text = "item: "+myList.itemName)
            Text(text = "qnt: "+myList.quantity)
            Row {
                IconButton(onClick = {
                    onEditClick()
                    Log.d("Edit","edit")
>>>>>>> dev
                }) {
                    Icon(Icons.Filled.Create, contentDescription = "update")
                }
                IconButton(onClick = {
<<<<<<< HEAD
                    /*TODO*/
                }) {
                    Icon(Icons.Filled.Delete, contentDescription = "Delete")
=======
                    onDeleteClick()
                    Log.d("Delete","delete")
                }) {
                    Icon(Icons.Filled.Delete, contentDescription = "Delete")

>>>>>>> dev
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShoppingListAppPreview() {
<<<<<<< HEAD
    ShoppingListApp()
}
/*
@Preview(showBackground = true)
@Composable
fun AlertDialogPreview()
{
    var itemName by remember {
        mutableStateOf("")
    }
    var itemQnt by remember {
        mutableStateOf("")
    }
    var isOpenDialog by remember {
        mutableStateOf(false)
    }
    AlertDialogUI(itemName,itemQnt,{newitem-> itemName = newitem},{newqnt->itemQnt = newqnt},isOpenDialog)
}
 */
=======
    var name by remember{
        mutableStateOf("")
    }

    Row (
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement =  Arrangement.SpaceEvenly
    ){
        Column (
            modifier = Modifier.weight(3f)
        ){
            TextField(value = name,
                onValueChange ={name = it} ,
                singleLine =  true,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp),
            )
            TextField(value = name,
                onValueChange ={name = it} ,
                singleLine =  true,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp),
            )
        }
        Button(onClick = {
//            isEditing = false
//            onEditComplete(itemName,itemQuantity.toIntOrNull()?:1)
        },
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(Color.Blue),
        ) {
            Text(
                "Save",
            )
        }
    }
}
>>>>>>> dev
