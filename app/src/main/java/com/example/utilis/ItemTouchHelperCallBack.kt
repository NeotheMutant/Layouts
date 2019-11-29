package com.example.utilis

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.core.content.ContextCompat.getDrawable
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.layouts.R


class ItemTouchHelperCallBack(val adapter: ItemTouchHelperAdapter) : ItemTouchHelper.Callback() {

    var background = ColorDrawable(Color.DKGRAY)
    val iconDrawable = getDrawable(adapter, R.drawable.ic_send_white_24dp)


    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {

        val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
        val swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END

        return ItemTouchHelper.Callback.makeMovementFlags(dragFlags, swipeFlags)


    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {

        adapter.onItemMoved(viewHolder.adapterPosition, target.adapterPosition)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        adapter.onItemDismiss(viewHolder.adapterPosition, direction, viewHolder)
    }


    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {

        val iconDrawable = getDrawable(viewHolder.itemView.context, R.drawable.ic_send_white_24dp)

        val itemView = viewHolder.itemView


        val iconMargin = (itemView.height - iconDrawable!!.intrinsicHeight) / 2


        val iconTop = itemView.top + (itemView.height - iconDrawable.intrinsicHeight) / 2
        val iconBottom = itemView.top + iconDrawable.intrinsicHeight

        val backgroundCornerOffset = 20

        when {
            dX > 0 -> { // Swiping to the right
                background = ColorDrawable(Color.GRAY)

                // iconDrawable = getDrawable(viewHolder.itemView.context,R.drawable.ic_send_white_24dp)

                val iconLeft = itemView.left + iconMargin
                val iconRight = itemView.left + iconDrawable.intrinsicWidth
                iconDrawable.setBounds(iconLeft, iconTop, iconRight, iconBottom)

                background.setBounds(
                    itemView.left, itemView.top,
                    itemView.left + dX.toInt() + backgroundCornerOffset,
                    itemView.bottom
                )

            }
            dX < 0 -> { // Swiping to the left

                //iconDrawable = getDrawable(viewHolder.itemView.context,R.drawable.ic_delete_white_24dp)
                background = ColorDrawable(Color.parseColor("#801336"))

                val iconLeft = itemView.left - iconMargin - iconDrawable.intrinsicWidth
                val iconRight = itemView.left  - iconMargin
                iconDrawable.setBounds(iconLeft, iconTop, iconRight, iconBottom)



                background.setBounds(
                    itemView.right + dX.toInt() - backgroundCornerOffset,
                    itemView.top, itemView.right, itemView.bottom
                )
            }
            else -> // view is unSwiped
                background.setBounds(0, 0, 0, 0)
        }
        background.draw(c)
        iconDrawable.draw(c)



        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }


    interface ItemTouchHelperAdapter {

        fun onItemMoved(fromPosition: Int, toPosition: Int)

        fun onItemDismiss(position: Int, direction: Int, viewHolder: RecyclerView.ViewHolder)



    }


}

