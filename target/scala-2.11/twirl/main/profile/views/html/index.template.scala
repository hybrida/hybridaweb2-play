
package profile.views.html

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
import profile.models.ImmutableUser
/**/
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[String,String,String,ImmutableUser,Boolean,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(username: String, name: String, imageFilePath: String, user: ImmutableUser, canEdit: Boolean, subTitle: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
def /*4.2*/infoItem/*4.10*/(label:String, value:String, valueIsHtml:Boolean = false):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.71*/("""
    """),format.raw/*5.5*/("""<li>
        <div class="label">"""),_display_(/*6.29*/label),format.raw/*6.34*/("""</div>
        <div class="info">"""),_display_(/*7.28*/if(valueIsHtml)/*7.43*/{_display_(Seq[Any](format.raw/*7.44*/(""" """),_display_(/*7.46*/Html(value)),format.raw/*7.57*/(""" """)))}/*7.59*/else/*7.63*/{_display_(Seq[Any](format.raw/*7.64*/(""" """),_display_(/*7.66*/value),format.raw/*7.71*/(""" """)))}),format.raw/*7.73*/("""</div>
        <div class="clearfix"></div>
    </li>
""")))};
Seq[Any](format.raw/*2.114*/("""

"""),format.raw/*10.2*/("""

"""),format.raw/*12.1*/("""<div class="container-fluid center-container nedit space-above">
    <div class="row space-below">
        <div class="col-xs-12">
            <div class="page-box">
                <div class="row">
                    <div class="col-xs-12">
                        """),_display_(/*18.26*/if(canEdit)/*18.37*/ {_display_(Seq[Any](format.raw/*18.39*/("""
                            """),format.raw/*19.29*/("""<div class="buttons btn-group pull-right">
                                <a class="btn btn-primary btn-sm" href=""""),_display_(/*20.74*/profile/*20.81*/.routes.Profile.edit(username)),format.raw/*20.111*/("""">Rediger</a>
                            </div>
                        """)))}),format.raw/*22.26*/("""
                        """),format.raw/*23.25*/("""<h5 class="top-text">"""),_display_(/*23.47*/name),format.raw/*23.51*/("""</h5>
                    </div>
                    <div class="col-xl-6 pull-right space-above">
                        <div class="picFrame poof">
                            <img class="pic super-center" src=""""),_display_(/*27.65*/imageFilePath),format.raw/*27.78*/("""">
                        </div>
                    </div>
                    <div class="col-xl-6 pull-left space-above">
                        <h1 class="big-title">"""),_display_(/*31.48*/name),format.raw/*31.52*/("""</h1>
                        """),_display_(/*32.26*/if(subTitle != null && !subTitle.equals(""))/*32.70*/ {_display_(Seq[Any](format.raw/*32.72*/("""
                            """),format.raw/*33.29*/("""<h3 class="big-sub-title">"""),_display_(/*33.56*/subTitle),format.raw/*33.64*/("""</h3>
                        """)))}),format.raw/*34.26*/("""

                        """),format.raw/*36.25*/("""<div class="info-block-container">
                            <div class="info-block">
                                <ul>
                                    """),_display_(/*39.38*/infoItem("NTNU-E-POST", username+"@stud.ntnu.no")),format.raw/*39.87*/("""
                                    """),_display_(/*40.38*/if(user.hasEmail)/*40.55*/{_display_(Seq[Any](format.raw/*40.56*/(""" """),_display_(/*40.58*/infoItem("ALTERNATIV E-POST", user.getEmail))))}),format.raw/*40.103*/("""
                                    """),_display_(/*41.38*/if(user.hasWebsiteUrl)/*41.60*/{_display_(Seq[Any](format.raw/*41.61*/(""" """),_display_(/*41.63*/infoItem("HJEMMESIDE", "<a href='" +
                                            (if(user.getWebsiteUrl.substring(0, 4) != "http") "http://" else "")
                                            + user.getWebsiteUrl + "' alt='" + user.getFirstName + "s hjemmeside'>"
                                            + user.getWebsiteUrl + "</a>", true))))}),format.raw/*44.82*/("""
                                    """),_display_(/*45.38*/if(user.hasPhone)/*45.55*/{_display_(Seq[Any](format.raw/*45.56*/(""" """),_display_(/*45.58*/infoItem("TELEFON", user.getPhone))))}),format.raw/*45.93*/("""
                                """),format.raw/*46.33*/("""</ul>
                            </div>
                            <div class="info-block">
                                <ul>
                                    """),_display_(/*50.38*/infoItem("MEDLEMSKAP", if(user.isMember) "Medlem" else "Ikke medlem")),format.raw/*50.107*/("""
                                    """),_display_(/*51.38*/if(user.hasTitle)/*51.55*/{_display_(Seq[Any](format.raw/*51.56*/(""" """),_display_(/*51.58*/infoItem("TITTEL", user.getTitle))))}),format.raw/*51.92*/("""
                                    """),_display_(/*52.38*/if(!user.getMemberships.isEmpty)/*52.70*/{_display_(Seq[Any](format.raw/*52.71*/(""" """),_display_(/*52.73*/infoItem("MEDLEM AV", util.TextUtil.capitalized(util.ArrayUtil.prettyJoin(user.getMemberships))))))}),format.raw/*52.170*/("""
                                    """),_display_(/*53.38*/if(user.hasGraduationYear)/*53.64*/{_display_(Seq[Any](format.raw/*53.65*/(""" """),_display_(/*53.67*/infoItem("AVGANGSÅR", user.getGraduationYear.toString))))}),format.raw/*53.122*/("""
                                    """),_display_(/*54.38*/if(user.hasSpecialization)/*54.64*/{_display_(Seq[Any](format.raw/*54.65*/(""" """),_display_(/*54.67*/infoItem("SPESIALISERING", user.getSpecialization.toString))))}),format.raw/*54.127*/("""
                                    """),_display_(/*55.38*/if(user.hasCardCode)/*55.58*/{_display_(Seq[Any](format.raw/*55.59*/(""" """),_display_(/*55.61*/infoItem("KORTKODE", user.getCardCode))))}),format.raw/*55.100*/("""
                                """),format.raw/*56.33*/("""</ul>
                            </div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
    </div>
</div>"""))}
  }

  def render(username:String,name:String,imageFilePath:String,user:ImmutableUser,canEdit:Boolean,subTitle:String): play.twirl.api.HtmlFormat.Appendable = apply(username,name,imageFilePath,user,canEdit,subTitle)

  def f:((String,String,String,ImmutableUser,Boolean,String) => play.twirl.api.HtmlFormat.Appendable) = (username,name,imageFilePath,user,canEdit,subTitle) => apply(username,name,imageFilePath,user,canEdit,subTitle)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/profile/views/index.scala.html
                  HASH: 5f95a8798e921777ce95c7022df081ea60b2d605
                  MATRIX: 809->39|992->156|1008->164|1145->225|1177->231|1237->265|1262->270|1323->305|1346->320|1384->321|1412->323|1443->334|1463->336|1475->340|1513->341|1541->343|1566->348|1598->350|1696->151|1727->408|1758->412|2060->687|2080->698|2120->700|2178->730|2322->847|2338->854|2390->884|2497->960|2551->986|2600->1008|2625->1012|2871->1231|2905->1244|3109->1421|3134->1425|3193->1457|3246->1501|3286->1503|3344->1533|3398->1560|3427->1568|3490->1600|3546->1628|3738->1793|3808->1842|3874->1881|3900->1898|3939->1899|3968->1901|4038->1946|4104->1985|4135->2007|4174->2008|4203->2010|4577->2360|4643->2399|4669->2416|4708->2417|4737->2419|4796->2454|4858->2488|5057->2660|5148->2729|5214->2768|5240->2785|5279->2786|5308->2788|5366->2822|5432->2861|5473->2893|5512->2894|5541->2896|5663->2993|5729->3032|5764->3058|5803->3059|5832->3061|5912->3116|5978->3155|6013->3181|6052->3182|6081->3184|6166->3244|6232->3283|6261->3303|6300->3304|6329->3306|6393->3345|6455->3379
                  LINES: 26->2|28->4|28->4|30->4|31->5|32->6|32->6|33->7|33->7|33->7|33->7|33->7|33->7|33->7|33->7|33->7|33->7|33->7|37->2|39->10|41->12|47->18|47->18|47->18|48->19|49->20|49->20|49->20|51->22|52->23|52->23|52->23|56->27|56->27|60->31|60->31|61->32|61->32|61->32|62->33|62->33|62->33|63->34|65->36|68->39|68->39|69->40|69->40|69->40|69->40|69->40|70->41|70->41|70->41|70->41|73->44|74->45|74->45|74->45|74->45|74->45|75->46|79->50|79->50|80->51|80->51|80->51|80->51|80->51|81->52|81->52|81->52|81->52|81->52|82->53|82->53|82->53|82->53|82->53|83->54|83->54|83->54|83->54|83->54|84->55|84->55|84->55|84->55|84->55|85->56
                  -- GENERATED --
              */
          