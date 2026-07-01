package com.reactpinvest

import android.graphics.Color
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewManagerDelegate
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.ReactPinvestViewManagerInterface
import com.facebook.react.viewmanagers.ReactPinvestViewManagerDelegate

@ReactModule(name = ReactPinvestViewManager.NAME)
class ReactPinvestViewManager : SimpleViewManager<ReactPinvestView>(),
  ReactPinvestViewManagerInterface<ReactPinvestView> {
  private val mDelegate: ViewManagerDelegate<ReactPinvestView>

  init {
    mDelegate = ReactPinvestViewManagerDelegate(this)
  }

  override fun getDelegate(): ViewManagerDelegate<ReactPinvestView>? {
    return mDelegate
  }

  override fun getName(): String {
    return NAME
  }

  public override fun createViewInstance(context: ThemedReactContext): ReactPinvestView {
    return ReactPinvestView(context)
  }

  @ReactProp(name = "color")
  override fun setColor(view: ReactPinvestView?, color: Int?) {
    view?.setBackgroundColor(color ?: Color.TRANSPARENT)
  }

  companion object {
    const val NAME = "ReactPinvestView"
  }
}
