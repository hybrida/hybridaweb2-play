
package rfid.views.html

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
object reader extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[List[renders.models.Renders],Long,Int,Long,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(bedpresses: List[renders.models.Renders], chosenEventId: Long, currentColor: Int, number: Long):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.98*/("""

"""),format.raw/*3.1*/("""<div class="col-md-4 """),_display_(/*3.23*/if(currentColor==2||currentColor==1)/*3.59*/{_display_(Seq[Any](format.raw/*3.60*/("""bg-success""")))}),_display_(/*3.72*/if(currentColor==0)/*3.91*/{_display_(Seq[Any](format.raw/*3.92*/("""bg-warning""")))}),_display_(/*3.104*/if(currentColor== -1)/*3.125*/{_display_(Seq[Any](format.raw/*3.126*/("""bg-danger""")))}),format.raw/*3.136*/("""">
	<form action=""""),_display_(/*4.17*/rfid/*4.21*/.routes.RFIDReader.read()),format.raw/*4.46*/("""" method="post">
		<input name="rfid" type="text" autofocus>
		<input name="color" value=""""),_display_(/*6.31*/currentColor),format.raw/*6.43*/("""" type="submit" hidden>
		<select class="form-control" name="eventId">
			<option value="0">Velg Bedpres</option>
			"""),_display_(/*9.5*/for(i<-bedpresses) yield /*9.23*/{_display_(Seq[Any](format.raw/*9.24*/("""
				"""),format.raw/*10.5*/("""<option value=""""),_display_(/*10.21*/i/*10.22*/.eventReference.getId),format.raw/*10.43*/("""" """),_display_(/*10.46*/if(chosenEventId == i.eventReference.getId)/*10.89*/{_display_(Seq[Any](format.raw/*10.90*/("""selected""")))}),format.raw/*10.99*/(""">"""),_display_(/*10.101*/i/*10.102*/.eventReference.getArticle.getTitle),format.raw/*10.137*/("""</option>
			""")))}),format.raw/*11.5*/("""
		"""),format.raw/*12.3*/("""</select>
	</form>
	"""),_display_(/*14.3*/if(number!=0)/*14.16*/{_display_(Seq[Any](format.raw/*14.17*/("""<p>"""),_display_(/*14.21*/number),format.raw/*14.27*/("""</p>""")))}),format.raw/*14.32*/("""
"""),format.raw/*15.1*/("""</div>
"""))}
  }

  def render(bedpresses:List[renders.models.Renders],chosenEventId:Long,currentColor:Int,number:Long): play.twirl.api.HtmlFormat.Appendable = apply(bedpresses,chosenEventId,currentColor,number)

  def f:((List[renders.models.Renders],Long,Int,Long) => play.twirl.api.HtmlFormat.Appendable) = (bedpresses,chosenEventId,currentColor,number) => apply(bedpresses,chosenEventId,currentColor,number)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/rfid/views/reader.scala.html
                  HASH: 195bc8a3593c2153141f634fcdcba6c4a4459ff4
                  MATRIX: 765->1|949->97|979->101|1027->123|1071->159|1109->160|1150->172|1177->191|1215->192|1257->204|1287->225|1326->226|1367->236|1413->256|1425->260|1470->285|1589->378|1621->390|1767->511|1800->529|1838->530|1871->536|1914->552|1924->553|1966->574|1996->577|2048->620|2087->621|2127->630|2157->632|2168->633|2225->668|2270->683|2301->687|2350->710|2372->723|2411->724|2442->728|2469->734|2505->739|2534->741
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|31->3|31->3|31->3|31->3|31->3|31->3|32->4|32->4|32->4|34->6|34->6|37->9|37->9|37->9|38->10|38->10|38->10|38->10|38->10|38->10|38->10|38->10|38->10|38->10|38->10|39->11|40->12|42->14|42->14|42->14|42->14|42->14|42->14|43->15
                  -- GENERATED --
              */
          