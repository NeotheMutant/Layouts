package com.example.layouts

import android.content.Intent
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_imagefilter.view.*
import kotlinx.android.synthetic.main.contact_view.view.*
import kotlinx.android.synthetic.main.contact_view.view.tvName
import kotlinx.android.synthetic.main.contact_view_img.view.*

class ContactAdapter(private val contactList: ArrayList<ContactInfo>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val HAS_IMAGE = 1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType == HAS_IMAGE) {

            ViewHolderImage(parent.context.inflaterr(R.layout.contact_view_img))

        } else {
            ViewHolder(parent.infalter(R.layout.contact_view))
        }

    }

    override fun getItemCount() = contactList.size


    override fun getItemViewType(position: Int): Int {

        return contactList[position].hasImage
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is ViewHolderImage) {
            holder.onBind(contactList[position])
        } else
            if (holder is ViewHolder) {
                holder.onBind(contactList[position])
            }


    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun onBind(contactInfo: ContactInfo) {

            with(itemView) {
                tvName.text = contactInfo.name
                tvFirstWord.text = contactInfo.name.firstOrNull().toString()
                tvFirstWord.background.setTint(randomColor())

                itemView.setOnClickListener {

                    Intent(context, ContactDetailActivity::class.java).apply {
                        putExtra(NAME, contactInfo.name)
                        putExtra(NUMBER, contactInfo.phoneNumber)
                        context.startActivity(this)

                    }


                }


            }


        }


    }

    class ViewHolderImage(view: View) : RecyclerView.ViewHolder(view) {

        fun onBind(contactInfo: ContactInfo) {

            with(itemView) {
                tvName.text = contactInfo.name
                imContactImage.setImageResource(contactInfo.ImgId)
                imContactImage.background?.setTint(randomColor())

                itemView.setOnClickListener {

                    Intent(context, ContactDetailActivity::class.java).apply {
                        putExtra("NAME", contactInfo.name)
                        putExtra("NUMBER", contactInfo.phoneNumber)
                        context.startActivity(this)

                    }


                }


            }


        }


    }

    companion object Details {
        const val NAME = "NAME"
        const val NUMBER = "NUMBER"
    }
}

