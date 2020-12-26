package com.tibagni.logviewer

import com.tibagni.logviewer.preferences.LogViewerPreferences
import com.tibagni.logviewer.preferences.LogViewerPreferencesImpl

object ServiceLocator {
  val logViewerPrefs: LogViewerPreferences = LogViewerPreferencesImpl
  val logsRepository: LogsRepository = LogsRepositoryImpl()
  val filtersRepository: FiltersRepository = FiltersRepositoryImpl()
}