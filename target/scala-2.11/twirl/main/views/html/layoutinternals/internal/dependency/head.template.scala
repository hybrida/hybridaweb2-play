
package views.html.layoutinternals.internal.dependency

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
object head extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<!-- JQUERY -->
<!-- Minified JavaScript -->
<script src=""""),_display_(/*3.15*/routes/*3.21*/.Assets.at("javascripts/jquery-1.11.2.min.js")),format.raw/*3.67*/("""" type="text/javascript"></script>

<!-- BOOTSTRAP -->
<!-- Minified CSS -->
<link rel="stylesheet" type="text/css" href=""""),_display_(/*7.47*/routes/*7.53*/.Assets.at("bootstrap/bootstrap.min.css")),format.raw/*7.94*/("""">
<!-- Optional theme -->
<link rel="stylesheet" type="text/css" href=""""),_display_(/*9.47*/routes/*9.53*/.Assets.at("bootstrap/bootstrap-theme.min.css")),format.raw/*9.100*/("""">
<!-- Minified JavaScript -->
<script type="text/javascript" src=""""),_display_(/*11.38*/routes/*11.44*/.Assets.at("bootstrap/bootstrap.min.js")),format.raw/*11.84*/(""""></script>
<!-- Custom XL column -->
<link rel="stylesheet" type="text/css" href=""""),_display_(/*13.47*/routes/*13.53*/.Assets.at("stylesheets/bootstrapxl.css")),format.raw/*13.94*/("""">
<script type="text/javascript" src=""""),_display_(/*14.38*/routes/*14.44*/.Assets.at("javascripts/bootstrapxl.js")),format.raw/*14.84*/(""""></script>

<!-- GOOGLE FONTS -->
<link href='http://fonts.googleapis.com/css?family=Raleway+Dots' rel='stylesheet' type='text/css'>

<!-- HYBRIDAWEB -->
<!-- Main CSS -->
<link rel="stylesheet" type="text/css" href=""""),_display_(/*21.47*/routes/*21.53*/.Assets.at("stylesheets/main.css")),format.raw/*21.87*/("""">
<!-- Main JavaScript -->
<script type="text/javascript" src=""""),_display_(/*23.38*/routes/*23.44*/.Assets.at("javascripts/main.js")),format.raw/*23.77*/(""""></script>
<!-- Shortcut icon -->
<link rel="shortcut icon" type="image/ico" href=""""),_display_(/*25.51*/routes/*25.57*/.Assets.at("favicon.ico")),format.raw/*25.82*/("""">
<!-- Meta Tags -->
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:42 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/views/layoutinternals/internal/dependency/head.scala.html
                  HASH: 2500106c8dbd94f9f8dcb176de5fe8bf2c185284
                  MATRIX: 833->0|920->61|934->67|1000->113|1153->240|1167->246|1228->287|1329->362|1343->368|1411->415|1509->486|1524->492|1585->532|1698->618|1713->624|1775->665|1843->706|1858->712|1919->752|2172->978|2187->984|2242->1018|2336->1085|2351->1091|2405->1124|2519->1211|2534->1217|2580->1242
                  LINES: 29->1|31->3|31->3|31->3|35->7|35->7|35->7|37->9|37->9|37->9|39->11|39->11|39->11|41->13|41->13|41->13|42->14|42->14|42->14|49->21|49->21|49->21|51->23|51->23|51->23|53->25|53->25|53->25
                  -- GENERATED --
              */
          