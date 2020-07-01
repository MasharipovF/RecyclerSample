package com.example.recyclersample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FragmentList : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = Adapter(activity, SampleData.DATA, { onClick(it) }, { onLongClick(it) })
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter

        fab.setOnClickListener {
            adapter.notifyItemInserted(SampleData.addItem())
        }
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentList.
         */
        // TODO: Rename and change types and number of parameters
        val TAG = FragmentList::class.java.simpleName
        val REQUEST_KEY = "requestKey"
        val KEY_VALUE = "bundleKey"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentList().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun onClick(id: Int) {
        (activity as MainActivity).replaceFragment(
            FragmentInfo.newInstance("", ""),
            FragmentInfo.TAG
        )

        setFragmentResult(REQUEST_KEY, bundleOf(KEY_VALUE to id))
    }

    private fun onLongClick(id: Int) {
        SampleData.deleteItem(id)
        adapter.notifyItemRemoved(id)

    }

}
