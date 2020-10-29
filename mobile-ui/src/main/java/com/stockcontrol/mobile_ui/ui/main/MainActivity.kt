package com.stockcontrol.mobile_ui.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.zxing.integration.android.IntentIntegrator
import com.stockcontrol.mobile_ui.R
import com.stockcontrol.mobile_ui.base.EventObserver
import com.stockcontrol.mobile_ui.base.model.SalesView
import com.stockcontrol.mobile_ui.base.model.StockItemView
import com.stockcontrol.mobile_ui.base.model.StockQuantitiesView
import com.stockcontrol.mobile_ui.base.utils.NetworkChecker.checkInternet
import com.stockcontrol.mobile_ui.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory : ViewModelProviderFactory

    @Inject
    lateinit var salesAdapter: SalesAdapter

    @Inject
    lateinit var stockQuantitiesAdapter: StockQuantitiesAdapter

    @Inject
    lateinit var linearLayoutManagerSales: LinearLayoutManager
    @Inject
    lateinit var linearLayoutManagerQts: LinearLayoutManager

    @Inject
    lateinit var alertDialog: AlertDialog.Builder

    lateinit var stockItemViewModel: StockItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        stockItemViewModel = ViewModelProvider(this,viewModelFactory).get(StockItemViewModel::class.java)
        if(checkInternet(this)) {
            scanCode()
        }
        else{
            showAlertDialog(resources.getString(R.string.connection_error) , true)
        }
    }

    override fun onStart() {
        super.onStart()
//        stockItemViewModel.getStockItem().observe(this ,object :Observer<Resource<StockItemView>> {
//            override fun onChanged(t: Resource<StockItemView>) {
//                handleState(t)
//            }
//        })

        // use the following way instead of the previous one to avoid multiple calling for onChanged fun

        stockItemViewModel.getStockItem().observe(this ,EventObserver {
            handleState(it)
        })

    }

    private fun handleState(resource: Resource<StockItemView>) {

        when(resource.status){
            Resource.Status.ERROR ->{
                Log.d("Error" ,resource.message )
                progressbar.visibility = View.GONE
                showAlertDialog(resources.getString(R.string.general_error) , true)
            }

            Resource.Status.LOADING -> {
                scan_code.visibility = View.GONE
                scroll_data_view.visibility = View.GONE
                progressbar.visibility = View.VISIBLE
            }

            Resource.Status.SUCCESS -> {
                resource.data?.let {
                    if (it.id.isEmpty()) {
                        showAlertDialog(resources.getString(R.string.empty_item), false)
                    } else {
                        item_no.text = it.id
                        item_name.text = it.name
                        item_price.text = it.price.toString()
                        salesAdapter.setAdapterList(it.sales as ArrayList<SalesView>)
                        stockQuantitiesAdapter.setAdapterList(it.stock as ArrayList<StockQuantitiesView>)
                        scan_code.visibility = View.VISIBLE
                        scroll_data_view.visibility = View.VISIBLE
                        progressbar.visibility = View.GONE
                    }
                }
            }
        }
    }

    private fun initRecyclersViews(){
        rv_invoices.layoutManager = linearLayoutManagerSales
        rv_invoices.adapter = salesAdapter

        rv_item_in_stocks.layoutManager = linearLayoutManagerQts
        rv_item_in_stocks.adapter = stockQuantitiesAdapter
    }

    private fun scanCode(){
        val integrator = IntentIntegrator(this)
        integrator.captureActivity = CaptureAct::class.java
        integrator.setOrientationLocked(false)
        integrator.setBeepEnabled(false)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
        integrator.setPrompt("Scanning code")
        integrator.initiateScan()
    }

    fun scanAnotherItem(view : View){
        finish()
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val result = IntentIntegrator.parseActivityResult(requestCode , resultCode , data)
        if(result != null){
            if(result.contents != null){
                initRecyclersViews()
                stockItemViewModel.fetchStockItemData(result.contents)
//                stockItemViewModel.fetchStockItemData("100100")
            }
            else{
                finish()
            }
        }
    }

    private fun showAlertDialog(message : String , close_app : Boolean){
        alertDialog.setMessage(message)
            .setPositiveButton(resources.getString(R.string.ok)) { dialog, _ ->
                if (close_app) {
                    finish()
                }
                else{
                    scanCode()
                }
            }
            .create()
        alertDialog.show()
    }
}