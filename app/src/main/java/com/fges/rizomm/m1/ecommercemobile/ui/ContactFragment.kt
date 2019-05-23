package com.fges.rizomm.m1.ecommercemobile.ui

import android.content.Context
import android.content.Intent
import android.icu.util.RangeValueIterator
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.fges.rizomm.m1.ecommercemobile.R
import com.fges.rizomm.m1.ecommercemobile.network.RetrofitFactory
import kotlinx.android.synthetic.main.about.*

import kotlinx.android.synthetic.main.fragment_list__of__product.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import mehdi.sakout.aboutpage.Element
import org.jetbrains.anko.support.v4.toast
import retrofit2.HttpException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ContactFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ContactFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ContactFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      val number ="0758412697"
call?.setOnClickListener(){

    val intent=Intent(Intent().action)
    intent.data= Uri.parse("tel"+ number)

}

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.about, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onDetach() {
        super.onDetach()
    }

}