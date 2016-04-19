
package bedpressblock.views.html

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
import renders.models.Renders
/**/
object selectUser extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Event,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(event: Event):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*2.16*/("""
"""),_display_(/*3.2*/pickbedpres(Renders.find.setMaxRows(10).where().eq("eventReference.bedpres", true).findList(), event.getId)),format.raw/*3.109*/("""
"""),format.raw/*4.1*/("""<form action=""""),_display_(/*4.16*/bedpressblock/*4.29*/.routes.BedPresBlock.blockUser()),format.raw/*4.61*/("""" method="post">
	<input type="hidden" name="eventId" value=""""),_display_(/*5.46*/event/*5.51*/.getId),format.raw/*5.57*/("""">
	<select class="form-control" name="userId" onchange="this.form.submit()">
		<option value="0" selected disabled>Velg Person</option>
		"""),_display_(/*8.4*/for(i<-event.getJoinedUsers) yield /*8.32*/{_display_(Seq[Any](format.raw/*8.33*/("""
			"""),format.raw/*9.4*/("""<option value=""""),_display_(/*9.20*/i/*9.21*/.getId),format.raw/*9.27*/("""">"""),_display_(/*9.30*/if(i.isBlockedFrom(event))/*9.56*/{_display_(Seq[Any](format.raw/*9.57*/("""&#9888;""")))}),format.raw/*9.65*/(""" """),_display_(/*9.67*/(i.getFirstName + " " + i.getLastName)),format.raw/*9.105*/("""</option>
		""")))}),format.raw/*10.4*/("""
	"""),format.raw/*11.2*/("""</select>
</form>
"""))}
  }

  def render(event:Event): play.twirl.api.HtmlFormat.Appendable = apply(event)

  def f:((Event) => play.twirl.api.HtmlFormat.Appendable) = (event) => apply(event)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/bedpressblock/views/selectUser.scala.html
                  HASH: 48384506a39ecbafdbf232771fd3b0d07375960c
                  MATRIX: 770->33|872->47|900->50|1028->157|1056->159|1097->174|1118->187|1170->219|1259->282|1272->287|1298->293|1466->436|1509->464|1547->465|1578->470|1620->486|1629->487|1655->493|1684->496|1718->522|1756->523|1794->531|1822->533|1881->571|1925->585|1955->588
                  LINES: 26->2|29->2|30->3|30->3|31->4|31->4|31->4|31->4|32->5|32->5|32->5|35->8|35->8|35->8|36->9|36->9|36->9|36->9|36->9|36->9|36->9|36->9|36->9|36->9|37->10|38->11
                  -- GENERATED --
              */
          