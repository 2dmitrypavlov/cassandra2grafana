package com.jactravel.databases

import com.jactravel.databases.table._
import com.jactravel.utils.Connection
import com.outworkers.phantom.database.Database
import com.outworkers.phantom.dsl.KeySpaceDef

/**
  * Created by fayaz on 27.05.17.
  */
class CassandraDatabase(val keySpace: KeySpaceDef) extends Database[CassandraDatabase](keySpace) {
  object clientSearch extends ClientSearchTable with Connector
  object searchInfo extends SearchInfoTable with Connector
}

object Tables {
  object CassandraDatabase extends CassandraDatabase(Connection.connector)

  final val clientSearchTable = CassandraDatabase.clientSearch
  final val searchInfo = CassandraDatabase.searchInfo
}
