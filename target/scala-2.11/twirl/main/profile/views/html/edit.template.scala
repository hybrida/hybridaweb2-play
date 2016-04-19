
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
import profile.models.User
import profile.models.Specialization
/**/
object edit extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[String,String,String,Form[User],Map[String, String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(username: String, name: String, imageFilePath: String, form: Form[User], messages: Map[String, String]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
def /*5.2*/infoItemTop/*5.13*/(label:String, name: String):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.45*/("""
    """),format.raw/*6.5*/("""<li class=""""),_display_(/*6.17*/name),format.raw/*6.21*/(""" """),_display_(/*6.23*/if(messages.contains(name))/*6.50*/{_display_(Seq[Any](format.raw/*6.51*/("""error""")))}),format.raw/*6.57*/("""">
        <div class="label">
            """),_display_(/*8.14*/Html(label)),format.raw/*8.25*/("""
        """),format.raw/*9.9*/("""</div>
        """),_display_(/*10.10*/if(messages.contains(name))/*10.37*/ {_display_(Seq[Any](format.raw/*10.39*/("""
            """),format.raw/*11.13*/("""<div class="hide message">"""),_display_(/*11.40*/(messages(name))),format.raw/*11.56*/("""</div>
        """)))}),format.raw/*12.10*/("""
        """),format.raw/*13.9*/("""<div class="info">
""")))};def /*15.2*/infoItemBottom/*15.16*/():play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*15.22*/("""
        """),format.raw/*16.9*/("""</div>
        <div class="clearfix"></div>
    </li>
""")))};def /*21.2*/infoItem/*21.10*/(label: String, value: String):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*21.44*/("""
    """),_display_(/*22.6*/infoItemTop(label, name)),format.raw/*22.30*/("""
        """),format.raw/*23.9*/("""<div class="input-container">
            """),_display_(/*24.14*/value),format.raw/*24.19*/("""
        """),format.raw/*25.9*/("""</div>
    """),_display_(/*26.6*/infoItemBottom()),format.raw/*26.22*/("""
""")))};def /*29.2*/inputItem/*29.11*/(label:String, value:String, name: String = "", inputType:String = "text"):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*29.89*/("""
    """),_display_(/*30.6*/infoItemTop(label, name)),format.raw/*30.30*/("""
    """),format.raw/*31.5*/("""<div class="input-container">
        <input type=""""),_display_(/*32.23*/inputType),format.raw/*32.32*/("""" name=""""),_display_(/*32.41*/name),format.raw/*32.45*/("""" value=""""),_display_(/*32.55*/value),format.raw/*32.60*/("""">
    </div>
    """),_display_(/*34.6*/infoItemBottom()),format.raw/*34.22*/("""
""")))};def /*37.2*/dropDownItem/*37.14*/(label:String, value:String, name: String = "", options: Array[String]):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*37.89*/("""
    """),_display_(/*38.6*/infoItemTop(label, name)),format.raw/*38.30*/("""
    """),format.raw/*39.5*/("""<div class="select-container">
        <select name=""""),_display_(/*40.24*/name),format.raw/*40.28*/("""">
            """),_display_(/*41.14*/for(option <- options) yield /*41.36*/ {_display_(Seq[Any](format.raw/*41.38*/("""
                """),format.raw/*42.17*/("""<option value=""""),_display_(/*42.33*/option),format.raw/*42.39*/("""""""),_display_(/*42.41*/if(value == option)/*42.60*/{_display_(Seq[Any](format.raw/*42.61*/(""" """),format.raw/*42.62*/("""selected="selected"""")))}),format.raw/*42.82*/(""">"""),_display_(/*42.84*/option),format.raw/*42.90*/("""</option>
            """)))}),format.raw/*43.14*/("""
        """),format.raw/*44.9*/("""</select>
    </div>
    """),_display_(/*46.6*/infoItemBottom()),format.raw/*46.22*/("""
""")))};
Seq[Any](format.raw/*3.106*/("""

"""),format.raw/*14.2*/("""
"""),format.raw/*19.2*/("""

"""),format.raw/*27.2*/("""

"""),format.raw/*35.2*/("""

"""),format.raw/*47.2*/("""

"""),format.raw/*49.1*/("""<div class="container-fluid center-container edit space-above">
    <form method="POST" action=""""),_display_(/*50.34*/profile/*50.41*/.routes.Profile.update(username)),format.raw/*50.73*/(""""
            onsubmit="$('#profile_image_file').prop('disabled', true)">
        <div class="row space-below">
            <div class="col-xs-12">
                <div class="page-box">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="buttons btn-group pull-right">
                                <a class="btn btn-primary  btn-sm" href=""""),_display_(/*58.75*/profile/*58.82*/.routes.Profile.index(username)),format.raw/*58.113*/("""">Avbryt</a>
                                <input class="btn btn-primary btn-sm" type="submit" value="Lagre">
                            </div>
                            <h5 class="top-text">"""),_display_(/*61.51*/name),format.raw/*61.55*/("""</h5>
                        </div>
                        <div class="col-xl-6 pull-right space-above">
                            <h3 class="big-sub-title">PROFILBILDE</h3>
                            """),_display_(/*65.30*/if(messages.contains("profileImageFileName"))/*65.75*/ {_display_(Seq[Any](format.raw/*65.77*/("""
                                """),format.raw/*66.33*/("""<div class="message">
                                    <span class="bubble"></span>
                                    <span class="show-when-active">"""),_display_(/*68.69*/(messages("profileImageFileName"))),format.raw/*68.103*/("""</span>
                                    <span class="hide-when-active">!</span>
                                </div>
                            """)))}),format.raw/*71.30*/("""
                            """),format.raw/*72.29*/("""<input type="file" name="profileImageFile" class="profile-image-file-input hidden">
                            <input type="hidden" name="profileImageFileName" class="profile-image-file-name"
                                    value=""""),_display_(/*74.45*/form("profileImageFileName")/*74.73*/.value),format.raw/*74.79*/("""">
                            <div class="picFrame poof">
                                <img class="loader" src=""""),_display_(/*76.59*/routes/*76.65*/.Assets.at("images/ajax-loader.gif")),format.raw/*76.101*/("""">
                                <img class="pic super-center" src=""""),_display_(/*77.69*/(if(imageFilePath != null && !imageFilePath.equals("")) {
                                    imageFilePath
                                }else{
                                    routes.Assets.at("images/placeholder-profile.jpg")
                                })),format.raw/*81.35*/("""">

                                <div class="pic-inner">
                                    <div class="link-container">
                                        <div class="link ajaxUpload">
                                            <span class="glyphicon glyphicon-upload"></span> Last opp bilde
                                        </div>
                                        <div class="link remove"""),_display_(/*88.65*/if(imageFilePath == null || imageFilePath.equals(""))/*88.118*/{_display_(Seq[Any](format.raw/*88.119*/(""" """),format.raw/*88.120*/("""hidden""")))}),format.raw/*88.127*/("""">
                                            <span class="glyphicon glyphicon-remove-circle"></span> Fjern bildet
                                        </div>
                                    </div>
                                    <div class="drop hidden">
                                        <span class="glyphicon glyphicon-ajaxUpload"></span> Slipp for å laste opp
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-6 pull-left space-above">
                            <h3 class="big-sub-title">BRUKERINFO</h3>
                            <div class="info-block">
                                <ul>
                                    """),_display_(/*102.38*/infoItem("BRUKERNAVN", form("username").value)),format.raw/*102.84*/("""
                                """),format.raw/*103.33*/("""</ul>
                            </div>
                            <div class="info-block">
                                <ul>
                                    """),_display_(/*107.38*/inputItem("FORNAVN", form("firstName").value, "firstName")),format.raw/*107.96*/("""
                                    """),_display_(/*108.38*/inputItem("MELLOMNAVN", form("middleName").value, "middleName")),format.raw/*108.101*/("""
                                    """),_display_(/*109.38*/inputItem("ETTERNAVN", form("lastName").value, "lastName")),format.raw/*109.96*/("""
                                """),format.raw/*110.33*/("""</ul>
                            </div>
                            <div class="info-block">
                                <ul>
                                    """),_display_(/*114.38*/inputItem("ALTERNATIV E-POST", form("email").value, "email", "email")),format.raw/*114.107*/("""
                                    """),_display_(/*115.38*/inputItem("HJEMMESIDE", form("websiteUrl").value, "websiteUrl")),format.raw/*115.101*/("""
                                    """),_display_(/*116.38*/inputItem("TELEFON", form("phone").value, "phone")),format.raw/*116.88*/("""
                                """),format.raw/*117.33*/("""</ul>
                            </div>
                            <div class="info-block">
                                <ul>
                                    """),_display_(/*121.38*/inputItem("TITTEL", form("title").value, "title")),format.raw/*121.87*/("""
                                    """),_display_(/*122.38*/dropDownItem("SPESIALISERING", form("specialization").value, "specialization",
                                        Specialization.displayNames())),format.raw/*123.71*/("""
                                    """),_display_(/*124.38*/infoItemTop("KORTKODE <span class=\"cardcode-help glyphicon glyphicon-info-sign\"><img src=\"" + routes.Assets.at("images/cardcode.png") +"\"></span>", "cardCode")),format.raw/*124.201*/("""
                                    """),format.raw/*125.37*/("""<div class="input-container">
                                        <input type="text" name="cardCode" value=""""),_display_(/*126.84*/form("cardCode")/*126.100*/.value),format.raw/*126.106*/("""">
                                    </div>
                                    """),_display_(/*128.38*/infoItemBottom()),format.raw/*128.54*/("""
                                """),format.raw/*129.33*/("""</ul>
                            </div>
                        </div>

                        <div class="clearfix">
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
    </form>
</div>"""))}
  }

  def render(username:String,name:String,imageFilePath:String,form:Form[User],messages:Map[String, String]): play.twirl.api.HtmlFormat.Appendable = apply(username,name,imageFilePath,form,messages)

  def f:((String,String,String,Form[User],Map[String, String]) => play.twirl.api.HtmlFormat.Appendable) = (username,name,imageFilePath,form,messages) => apply(username,name,imageFilePath,form,messages)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/profile/views/edit.scala.html
                  HASH: acaebd1390faa77904c32ce28256d013c462419f
                  MATRIX: 838->69|1013->178|1032->189|1140->221|1172->227|1210->239|1234->243|1262->245|1297->272|1335->273|1371->279|1443->325|1474->336|1510->346|1554->363|1590->390|1630->392|1672->406|1726->433|1763->449|1811->466|1848->476|1892->500|1915->514|1998->520|2035->530|2116->593|2133->601|2244->635|2277->642|2322->666|2359->676|2430->720|2456->725|2493->735|2532->748|2569->764|2595->772|2613->781|2768->859|2801->866|2846->890|2879->896|2959->949|2989->958|3025->967|3050->971|3087->981|3113->986|3160->1007|3197->1023|3223->1031|3244->1043|3396->1118|3429->1125|3474->1149|3507->1155|3589->1210|3614->1214|3658->1231|3696->1253|3736->1255|3782->1273|3825->1289|3852->1295|3881->1297|3909->1316|3948->1317|3977->1318|4028->1338|4057->1340|4084->1346|4139->1370|4176->1380|4230->1408|4267->1424|4310->173|4341->497|4370->588|4401->767|4432->1026|4463->1427|4494->1431|4619->1529|4635->1536|4688->1568|5141->1994|5157->2001|5210->2032|5437->2232|5462->2236|5700->2447|5754->2492|5794->2494|5856->2528|6040->2685|6096->2719|6282->2874|6340->2904|6606->3143|6643->3171|6670->3177|6816->3296|6831->3302|6889->3338|6988->3410|7281->3682|7729->4103|7792->4156|7832->4157|7862->4158|7901->4165|8740->4976|8808->5022|8871->5056|9071->5228|9151->5286|9218->5325|9304->5388|9371->5427|9451->5485|9514->5519|9714->5691|9806->5760|9873->5799|9959->5862|10026->5901|10098->5951|10161->5985|10361->6157|10432->6206|10499->6245|10671->6395|10738->6434|10924->6597|10991->6635|11133->6749|11160->6765|11189->6771|11302->6856|11340->6872|11403->6906
                  LINES: 27->3|29->5|29->5|31->5|32->6|32->6|32->6|32->6|32->6|32->6|32->6|34->8|34->8|35->9|36->10|36->10|36->10|37->11|37->11|37->11|38->12|39->13|40->15|40->15|42->15|43->16|46->21|46->21|48->21|49->22|49->22|50->23|51->24|51->24|52->25|53->26|53->26|54->29|54->29|56->29|57->30|57->30|58->31|59->32|59->32|59->32|59->32|59->32|59->32|61->34|61->34|62->37|62->37|64->37|65->38|65->38|66->39|67->40|67->40|68->41|68->41|68->41|69->42|69->42|69->42|69->42|69->42|69->42|69->42|69->42|69->42|69->42|70->43|71->44|73->46|73->46|75->3|77->14|78->19|80->27|82->35|84->47|86->49|87->50|87->50|87->50|95->58|95->58|95->58|98->61|98->61|102->65|102->65|102->65|103->66|105->68|105->68|108->71|109->72|111->74|111->74|111->74|113->76|113->76|113->76|114->77|118->81|125->88|125->88|125->88|125->88|125->88|139->102|139->102|140->103|144->107|144->107|145->108|145->108|146->109|146->109|147->110|151->114|151->114|152->115|152->115|153->116|153->116|154->117|158->121|158->121|159->122|160->123|161->124|161->124|162->125|163->126|163->126|163->126|165->128|165->128|166->129
                  -- GENERATED --
              */
          