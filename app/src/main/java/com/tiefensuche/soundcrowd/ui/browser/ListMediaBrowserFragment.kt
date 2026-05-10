package com.tiefensuche.soundcrowd.ui.browser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.media3.common.MediaItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.tiefensuche.soundcrowd.ui.browser.adapters.ListItemAdapter

internal open class ListMediaBrowserFragment : MediaBrowserFragment() {

    override fun onResult(items: List<MediaItem>) {
        super.onResult(items)
        mBrowserAdapter.notifyDataChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBrowserAdapter = ListItemAdapter(requests, mMediaFragmentListener)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val rootView = super.onCreateView(inflater, container, savedInstanceState)

        mRecyclerView.adapter = mBrowserAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(rootView.context)

        return rootView
    }
}