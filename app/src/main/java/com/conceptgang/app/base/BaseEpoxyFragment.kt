package com.smartpdftools.android.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.*
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.conceptgang.app.base.BaseFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback

abstract class BaseEpoxyFragment : BaseFragment(){

   /* protected lateinit var baseBinding: FragmentEpoxyBaseBinding

    protected open var zhItemDecoration: BaseItemDecoration = BaseItemDecoration()
    protected abstract val zhViewCallback: ZHViewCallback
    private lateinit var behavior: BottomSheetBehavior<View>
    private var isHomePage = true;


    private val zhViewController: ZHViewController by lazy {
        ZHViewController(
            zhViewCallback
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        baseBinding = FragmentEpoxyBaseBinding.inflate(inflater, container, false)

        return baseBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewCompat.setOnApplyWindowInsetsListener(baseBinding.appbarLayout) { _, insets ->

            val toolbarHeight = requireContext().getDimenFromStyleAttr(android.R.attr.actionBarSize) + insets.systemWindowInsetTop

            baseBinding.toolbar.run {
                updateLayoutParams<ViewGroup.LayoutParams> {
                    height = toolbarHeight
                }

                updatePadding(top = insets.systemWindowInsetTop)
            }

            baseBinding.toolbarWhite.run {
                updateLayoutParams<ViewGroup.LayoutParams> {
                    height = toolbarHeight
                }

                updatePadding(top = insets.systemWindowInsetTop)
            }
            insets
        }

        baseBinding.collapsingToolbar.title = getString(R.string.app_name)
        baseBinding.searchImage.changeImageColor(ContextCompat.getColor(requireContext(), R.color.icon_grey))
        baseBinding.searchImageWhite.changeImageColor(ContextCompat.getColor(requireContext(), R.color.icon_grey))

        baseBinding.toolbarWhite.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        baseBinding.recyclerView.setController(zhViewController)
        baseBinding.recyclerView.addItemDecoration(zhItemDecoration)

        setupBottomSheet()


    }

    fun setupBottomSheet(){
        behavior = BottomSheetBehavior.from(baseBinding.coordinatorLayout.bottomSheet)

        behavior.addBottomSheetCallback(object : BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_DRAGGING && !isHomePage) {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        })

        baseBinding.bottomSheet.buttonImageTwo.changeImageColor(ContextCompat.getColor(requireContext(), R.color.icon_grey))
        baseBinding.bottomSheet.buttonImageThree.changeImageColor(ContextCompat.getColor(requireContext(), R.color.icon_grey))

        baseBinding.bottomSheet.quickWordCard.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.pdf_to_word).transParentBG)
        baseBinding.bottomSheet.quickJpgCard.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.pdf_to_jpg).transParentBG)
        baseBinding.bottomSheet.quickExcelCard.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.excel_to_pdf).transParentBG)
        baseBinding.bottomSheet.quickPsCard.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.pdf_to_ps).transParentBG)
        baseBinding.bottomSheet.quickPptCard.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.pdf_to_ppt).transParentBG)
        baseBinding.bottomSheet.quickHtmlCard.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.pdf_to_html).transParentBG)
        baseBinding.bottomSheet.quickPngCard.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.pdf_to_png).transParentBG)
        baseBinding.bottomSheet.quickTxtCard.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.pdf_to_txt).transParentBG)
        baseBinding.bottomSheet.quickTiffCard.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.pdf_to_tiff).transParentBG)
        baseBinding.bottomSheet.quickBmpCard.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.pdf_to_bmp).transParentBG)
        baseBinding.bottomSheet.quickToolsCard.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.merge_pdf).transParentBG)

        val linearLayoutManager = baseBinding.recyclerView.layoutManager as LinearLayoutManager
        
        val offset = 350

        baseBinding.bottomSheet.quickToolsCard.setOnClickListener {
            behavior.state = BottomSheetBehavior.STATE_COLLAPSED
            baseBinding.appbarLayout.setExpanded(false, true)
            linearLayoutManager.scrollToPositionWithOffset(1, offset)
        }
        baseBinding.bottomSheet.quickJpgCard.setOnClickListener {
            behavior.state = BottomSheetBehavior.STATE_COLLAPSED
            baseBinding.appbarLayout.setExpanded(false, true)
            linearLayoutManager.scrollToPositionWithOffset(2, offset)
        }
        baseBinding.bottomSheet.quickWordCard.setOnClickListener {
            behavior.state = BottomSheetBehavior.STATE_COLLAPSED
            baseBinding.appbarLayout.setExpanded(false, true)
            linearLayoutManager.scrollToPositionWithOffset(3, offset)
        }
        baseBinding.bottomSheet.quickTxtCard.setOnClickListener {
            behavior.state = BottomSheetBehavior.STATE_COLLAPSED
            baseBinding.appbarLayout.setExpanded(false, true)
            linearLayoutManager.scrollToPositionWithOffset(4, offset)
        }
        baseBinding.bottomSheet.quickPngCard.setOnClickListener {
            behavior.state = BottomSheetBehavior.STATE_COLLAPSED
            baseBinding.appbarLayout.setExpanded(false, true)
            linearLayoutManager.scrollToPositionWithOffset(5, offset)
        }
        baseBinding.bottomSheet.quickPsCard.setOnClickListener {
            behavior.state = BottomSheetBehavior.STATE_COLLAPSED
            baseBinding.appbarLayout.setExpanded(false, true)
            linearLayoutManager.scrollToPositionWithOffset(6, offset)
        }
        baseBinding.bottomSheet.quickExcelCard.setOnClickListener {
            behavior.state = BottomSheetBehavior.STATE_COLLAPSED
            //baseBinding.recyclerView.scrollToPosition(7)
            baseBinding.appbarLayout.setExpanded(false, true)
            linearLayoutManager.scrollToPositionWithOffset(6, offset)
        }
        baseBinding.bottomSheet.quickHtmlCard.setOnClickListener {
            behavior.state = BottomSheetBehavior.STATE_COLLAPSED
            baseBinding.appbarLayout.setExpanded(false, true)
            linearLayoutManager.scrollToPositionWithOffset(7, offset)
        }
        baseBinding.bottomSheet.quickTiffCard.setOnClickListener {
            behavior.state = BottomSheetBehavior.STATE_COLLAPSED
            baseBinding.appbarLayout.setExpanded(false, true)
            linearLayoutManager.scrollToPositionWithOffset(8, offset)
        }
        baseBinding.bottomSheet.quickPptCard.setOnClickListener {
            behavior.state = BottomSheetBehavior.STATE_COLLAPSED
            baseBinding.appbarLayout.setExpanded(false, true)
            linearLayoutManager.scrollToPositionWithOffset(9, offset)
        }
        baseBinding.bottomSheet.quickBmpCard.setOnClickListener {
            behavior.state = BottomSheetBehavior.STATE_COLLAPSED
            baseBinding.appbarLayout.setExpanded(false, true)
            linearLayoutManager.scrollToPositionWithOffset(10, offset)

        }
    }

    protected fun setEpoxyData(data: List<ZHViewData>){
        zhItemDecoration.views = data
        zhViewController.setData(data)
    }*/

}
