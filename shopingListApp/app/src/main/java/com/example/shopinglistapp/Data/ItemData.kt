package com.example.shopinglistapp.Data

import com.example.shopinglistapp.model.ShoppingListItem

class ShoppingListItemData()
{
    var shoppingData = listOf<ShoppingListItem>()

    fun modifyItemData(ID :Int,itemN:String,itemQ:String)
    {
            for(x in shoppingData)
            {
                if(x.id == ID)
                {
                    x.itemName = itemN
                    x.quantity = itemQ.toInt()
                }
            }
    }
    fun deleteItemData(ID:Int)
    {
        for(x in shoppingData)
        {
            if(x.id == ID)
            {
                shoppingData -= x
            }
        }
    }
}