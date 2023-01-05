package com.example.shoppinglistapp

import android.app.Activity
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.shoppinglistapp.database.Category
import com.example.shoppinglistapp.database.CategoryDatabase
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
class AddCategory : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_add_category, container, false)
        val addCategory = view.findViewById<Button>(R.id.closebtn)
        val addcategory = view.findViewById<Button>(R.id.addcategory)
        val categorytitleEditfield = view.findViewById<EditText>(R.id.categorytitle)
        val categorydescriptionEditField = view.findViewById<EditText>(R.id.categorydescription)
        addCategory.setOnClickListener{
            dismiss()
        }
        addcategory.setOnClickListener{
            val categorytitle = categorytitleEditfield.text.toString()
            val categorydescription = categorydescriptionEditField.text.toString()

            if(categorytitle.isEmpty())
            {
                categorytitleEditfield.error = "Category Title Required"
                categorytitleEditfield.requestFocus()
                return@setOnClickListener
            }
            if(categorydescription.isEmpty())
            {
                categorydescriptionEditField.error = "Category Description is required"
                categorydescriptionEditField.requestFocus()
                return@setOnClickListener
            }
            val category = Category(categorytitle,categorydescription)
            savecategory(category)

        }
        return view;

    }
    private fun savecategory(category: Category)
    {
        class SaveCategory: AsyncTask<Void,Void,Void>() {
            override fun doInBackground(vararg p0: Void?): Void? {
                context?.let { it1 ->
                    CategoryDatabase(it1).getCategoryDao().insertCategory(category)}
                     return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                Toast.makeText(activity,"Category added",Toast.LENGTH_SHORT).show()
            }
        }
        SaveCategory().execute()
    }
}