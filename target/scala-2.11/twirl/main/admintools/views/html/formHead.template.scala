
package admintools.views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object formHead extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Long,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(uid: Long):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.13*/("""<form action=""""),_display_(/*1.28*/admintools/*1.38*/.routes.Admin.editUser(uid.toString)),format.raw/*1.74*/("""" method="post" id="form_"""),_display_(/*1.100*/uid),format.raw/*1.103*/(""""></form>
"""))}
  }

  def render(uid:Long): play.twirl.api.HtmlFormat.Appendable = apply(uid)

  def f:((Long) => play.twirl.api.HtmlFormat.Appendable) = (uid) => apply(uid)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:40 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/admintools/views/formHead.scala.html
                  HASH: 5c288395edb808835b43dc7b716b880498d9f8fc
                  MATRIX: 735->1|834->12|875->27|893->37|949->73|1002->99|1026->102
                  LINES: 26->1|29->1|29->1|29->1|29->1|29->1|29->1
                  -- GENERATED --
              */
          