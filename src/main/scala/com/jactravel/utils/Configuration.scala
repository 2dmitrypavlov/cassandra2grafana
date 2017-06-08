package com.jactravel.utils

import com.typesafe.config.ConfigFactory

/**
  * Created by fayaz on 08.06.17.
  */
trait Configuration {

  private val config = ConfigFactory.load()

  final val host: String = config.getString("app.host")
  final val port: Int = config.getInt("app.port")
}