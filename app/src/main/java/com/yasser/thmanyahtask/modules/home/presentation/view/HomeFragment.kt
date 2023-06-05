package com.yasser.thmanyahtask.modules.home.presentation.view

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.yasser.thmanyahtask.R
import com.yasser.thmanyahtask.base.presentation.view.BaseFragment
import com.yasser.thmanyahtask.base.presentation.view.customview.showLoading
import com.yasser.thmanyahtask.databinding.FragmentHomeBinding
import com.yasser.thmanyahtask.modules.home.presentation.adapter.BroadcastHeaderAdapter
import com.yasser.thmanyahtask.modules.home.presentation.adapter.EpisodeListAdapter
import com.yasser.thmanyahtask.modules.home.presentation.adapter.listener.BroadcastActionListener
import com.yasser.thmanyahtask.modules.home.presentation.uimodel.*
import com.yasser.thmanyahtask.modules.home.presentation.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding,HomeUiModel,HomeUiState,HomeUIEffects,HomeUIEvents,HomeViewModel>(),
    BroadcastActionListener {
    override val viewModel by viewModels<HomeViewModel>()

    private val broadcastHeaderAdapter: BroadcastHeaderAdapter by lazy {
        BroadcastHeaderAdapter(requireContext(),this)
    }
    private val episodeListAdapter:EpisodeListAdapter by lazy {
        EpisodeListAdapter(requireContext(),::onSpecificEpisodePlayClick,::onSpecificEpisodeMenuClick)
    }

    override fun bindView(): FragmentHomeBinding {
       return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        binding.broadcastRecycler.apply {
            adapter= ConcatAdapter(broadcastHeaderAdapter,episodeListAdapter)
            layoutManager= LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        }
        viewModel.sendEvent(HomeUIEvents.GetBroadcastData)
    }

    override fun initListener() {

    }

    override fun render(ui: HomeUiModel) {



        ui.data?.let {
            broadcastHeaderAdapter.setBroadcastUiModel(it)
            episodeListAdapter.submitList(it.episodes)
        }
        binding.stateView.showLoading(ui.showLoading)
        when{
            ui.showNetworkError->{
                binding.stateView.setNetworkError(message = resources.getString(ui.errorMsg!!), retryAction = {
                    viewModel.sendEvent(HomeUIEvents.GetBroadcastData)
                }, retryTextColor = R.color.white,backgroundColor = R.color.white, retryBackground = R.drawable.ic_retry_btn_bg, retryIcon = R.drawable.ic_retry)
            }
            ui.showUnexpectedError->{
                binding.stateView.setError(
                    message = ui.errorMsg!!, retryAction = {
                        viewModel.sendEvent(HomeUIEvents.GetBroadcastData)
                    }, retryTextColor = R.color.white, retryBackground = R.drawable.ic_retry_btn_bg, backgroundColor = R.color.white, retryIcon = R.drawable.ic_retry
                )
            }
            ui.showEmptyState->{
                binding.stateView.setEmpty(emptyMsg = R.string.empty_episode)
            }
        }
    }

    override fun onBackClick() {

    }

    override fun onFavoriteClick(broadcastUiModel: BroadcastUiModel) {
        viewModel.sendEvent(HomeUIEvents.ToggleBroadcastToFavorite(broadcastUiModel))
    }

    override fun onOptionClick() {

    }

    override fun onPlayRandomEpisodesClick() {

    }

    override fun onDownloadClick() {

    }

    override fun onPlayEpisodesClick() {

    }

    private fun onSpecificEpisodePlayClick(episodeUiModel: EpisodeUiModel) {

    }

    private fun onSpecificEpisodeMenuClick(episodeUiModel: EpisodeUiModel) {

    }
}