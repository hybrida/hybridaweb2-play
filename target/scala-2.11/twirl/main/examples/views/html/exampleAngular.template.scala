
package examples.views.html

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
object exampleAngular extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html ng-app="store">
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    </head>
    <body ng-controller="StoreController as store">
        <ul class="list-group">
            <li class="list-group-item" ng-repeat="product in store.products | orderBy:'price'">
                <h3>
                    """),format.raw/*10.21*/("""{"""),format.raw/*10.22*/("""{"""),format.raw/*10.23*/("""product.name"""),format.raw/*10.35*/("""}"""),format.raw/*10.36*/("""}"""),format.raw/*10.37*/("""
                    """),format.raw/*11.21*/("""<em class="pull-right">"""),format.raw/*11.44*/("""{"""),format.raw/*11.45*/("""{"""),format.raw/*11.46*/("""product.price | currency:"€""""),format.raw/*11.74*/("""}"""),format.raw/*11.75*/("""}"""),format.raw/*11.76*/("""</em>
                </h3>
            </li>
        </ul>
        <script src=""""),_display_(/*15.23*/routes/*15.29*/.Assets.at("angular/angular.min.js")),format.raw/*15.65*/(""""></script>
        <script src=""""),_display_(/*16.23*/routes/*16.29*/.Assets.at("javascripts/examples/angular-app.js")),format.raw/*16.78*/(""""></script>
    </body>
</html>
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/examples/views/exampleAngular.scala.html
                  HASH: f501d681e57ace8948758dc7cee47adc773a485d
                  MATRIX: 816->0|1245->401|1274->402|1303->403|1343->415|1372->416|1401->417|1451->439|1502->462|1531->463|1560->464|1616->492|1645->493|1674->494|1787->580|1802->586|1859->622|1921->657|1936->663|2006->712
                  LINES: 29->1|38->10|38->10|38->10|38->10|38->10|38->10|39->11|39->11|39->11|39->11|39->11|39->11|39->11|43->15|43->15|43->15|44->16|44->16|44->16
                  -- GENERATED --
              */
          