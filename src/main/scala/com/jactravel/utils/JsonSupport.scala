package com.jactravel.utils

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import com.jactravel.databases.entity.ClientSearchEntity
import com.jactravel.models.DurationForm
import spray.json.{JsNumber, _}

import scala.language.implicitConversions

/**
  * Created by fayaz on 05.06.17.
  */
trait JsonSupport extends SprayJsonSupport with JsonHelperImplicits {

  /**
    * DurationForm object JSON parser
    */
  implicit val durationForm = jsonFormat3(DurationForm)

  /**
    * ClientSearchEntity object JSON parser
    */
  implicit object ClientFormat extends RootJsonFormat[ClientSearchEntity] {
    override def write(obj: ClientSearchEntity): JsValue = JsObject(
      "SearchQueryUUID" -> JsString(obj.SearchQueryUUID),
      "ClientIP" -> JsString(obj.ClientIP),
      "Host" -> JsString(obj.Host),
      "ClientRequestTimestamp" -> JsString(obj.ClientRequestTimestamp),
      "ClientResponseTimestamp" -> JsString(obj.ClientResponseTimestamp),
      "ForwardedRequestTimestamp" -> JsString(obj.ForwardedRequestTimestamp),
      "ForwardedResponseTimestamp" -> JsString(obj.ForwardedResponseTimestamp),
      "TradeID" -> JsNumber(obj.TradeID),
      "BrandID" -> JsNumber(obj.BrandID),
      "SalesChannelID" -> JsNumber(obj.SalesChannelID),
      "GeographyLevel1ID" -> JsNumber(obj.GeographyLevel1ID),
      "GeographyLevel2ID" -> JsNumber(obj.GeographyLevel2ID),
      "GeographyLevel3ID" -> obj.GeographyLevel3ID.toJson,
      "PropertyID" -> obj.PropertyID.toJson,
      "PropertyReferenceID" -> obj.PropertyReferenceID.toJson,
      "ArrivalDate" -> JsString(obj.ArrivalDate),
      "Duration" -> JsNumber(obj.Duration),
      "Rooms" -> JsNumber(obj.Duration),
      "Adults" -> obj.Adults.toJson,
      "Children" -> obj.Children.toJson,
      "ChildAges" -> obj.ChildAges.toJson,
      "MealBasisID" -> JsNumber(obj.MealBasisID),
      "MinStarRating" -> JsString(obj.MinStarRating),
      "HotelCount" -> JsNumber(obj.HotelCount),
      "Success" -> JsString(obj.Success),
      "ErroMessage" -> JsString(obj.ErrorMessage),
      "SuppliersSearched" -> JsNumber(obj.SuppliersSearched),
      "RequestXML" -> JsString(obj.RequestXML),
      "ResponseXML" -> JsString(obj.ResponseXML)
    )

    override def read(json: JsValue): ClientSearchEntity = {
      val fields = json.asJsObject.getFields(
        "SearchQueryUUID", "ClientIP", "Host", "ClientRequestTimestamp",
        "ClientResponseTimestamp", "ForwardedRequestTimestamp", "ForwardedResponseTimestamp",
        "TradeID", "BrandID", "SalesChannelID", "GeographyLevel1ID", "GeographyLevel2ID",
        "GeographyLevel3ID", "PropertyID", "PropertyReferenceID", "ArrivalDate",
        "Duration", "Rooms", "Adults", "Children", "ChildAges", "MealBasisID",
        "MinStarRating", "HotelCount", "Success", "ErroMessage", "SuppliersSearched",
        "RequestXML", "ResponseXML")
      fields match {
        case seq: Seq[JsValue] =>
          ClientSearchEntity(
            seq.head, seq(1), seq(2), seq(4), seq(5), seq(6), seq(7),
            seq(8), seq(9), seq(10), seq(11), seq(12), seq(13), seq(14),
            seq(15), seq(16), seq(17), seq(18), seq(19), seq(20), seq(21),
            seq(22), seq(23), seq(24), seq(25), seq(26), seq(27), seq(28), seq(29)
          )
        case _ => deserializationError("Cannot deserialize ClientSearchEntity")
      }
    }
  }
}