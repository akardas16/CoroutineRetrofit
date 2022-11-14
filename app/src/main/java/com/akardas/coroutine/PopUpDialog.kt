package com.akardas.coroutine

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.viewbinding.ViewBinding
import com.github.hariprasanths.bounceview.BounceView
import com.google.android.material.bottomsheet.BottomSheetDialog


object Dialog {
     fun PopUpDialog(context: Context, dialogBinding: ViewBinding, build:(alertDialog:AlertDialog) -> Unit) {
        val builder = AlertDialog.Builder(context)
        builder.setCancelable(false)
        builder.setView(dialogBinding.root)

        val alertDialog = builder.create()
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        BounceView.addAnimTo(alertDialog)

        build.invoke(alertDialog)

    }
     fun BottomSheetDialog(context: Context, bottomSheetBinding: ViewBinding, build:(bottomSheetDialog:BottomSheetDialog) -> Unit) {
        val bottomSheetDialog = BottomSheetDialog(context, R.style.BottomSheetDialog)
         bottomSheetDialog.apply {
             setContentView(bottomSheetBinding.root)
             window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
             setCanceledOnTouchOutside(true)
             setCancelable(true)
         }


        build.invoke(bottomSheetDialog)
    }
}