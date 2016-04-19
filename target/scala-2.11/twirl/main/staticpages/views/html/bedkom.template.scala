
package staticpages.views.html

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
object bedkom extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<div class="article-bg" style="background-image: url(../assets/images/bedrift1.jpg)">
    <div class="container">
        <div class="row space-above space-below" >
            <div class="col-md-10 col-md-offset-1 transparent-box rounded">
                <div class="text-center">
                    <h1>Bedkom</h1>
                </div>
                <div class="paragraph">
                    <h2>Info</h2>

                    <div>

                            <!-- Nav tabs -->
                        <ul class="nav nav-tabs" role="tablist">
                            <li role="presentation" class="active"><a href="#forside" aria-controls="home" role="tab" data-toggle="tab">Home</a></li>
                            <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Profile</a></li>
                            <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">Messages</a></li>
                            <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">Settings</a></li>
                        </ul>

                            <!-- Tab panes -->
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane active" id="forside">Home</div>
                            <div role="tabpanel" class="tab-pane" id="profile">Profil</div>
                            <div role="tabpanel" class="tab-pane" id="messages">Message</div>
                            <div role="tabpanel" class="tab-pane" id="settings">Settings</div>
                        </div>

                    </div>

                    <!--"""),_display_(/*31.26*/if(!models.LoginState.isValidlyLoggedIn)/*31.66*/ {_display_(Seq[Any](format.raw/*31.68*/("""<p>Dette er en test</p>""")))}/*31.93*/else/*31.97*/{_display_(Seq[Any](format.raw/*31.98*/("""<p>Dette er ikke en test</p>""")))}),format.raw/*31.127*/("""-->
                    <!--
                    <p>
                        <strong>Hybridas Bedriftskomite (Hybrida BedKom) har ansvaret for kontakten med bedriftene for sivilingeniørstudiet Ingeniørvitenskap og IKT (I &amp; IKT) ved NTNU. Vi ble etablert for å gi bedrifter informasjon om vårt studieprogram og hvilken kompetanse vi kan bidra med.</strong></p>
                    <p>
                        Hovedmålet vårt er at vi vil hjelpe studentene på linja med prosjektoppgaver, hovedoppgaver, sommerjobber og fast ansettelse. I tillegg kan bedriftsbesøk, ekskursjoner og temakvelder gi bedrifter og studenter mulighet til å snakke sammen.</p>
                    <p>
                        Arrangementer av denne typen krever samarbeid fra bedrifter. Hvis du kan bidra, kontakt oss gjerne via linken i menyen venstre. For en komplett liste med Hybrida Bedkoms oppgaver og gjøremål, se våre statutter i samme meny.</p>
                    <h2>Lorem ipsum:</h2>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut ligula arcu, tristique eget maximus non, elementum quis risus. Sed aliquet velit neque, id aliquam dui consequat ut. In in eros condimentum, scelerisque augue eget, suscipit libero. Etiam pulvinar rhoncus tortor sit amet auctor. Proin vel erat pharetra ipsum blandit facilisis. Suspendisse mollis lorem non congue iaculis. Donec at velit enim. Cras eu nisi congue, rhoncus arcu vel, tempor orci. Morbi convallis, orci nec luctus aliquet, mauris ligula rhoncus eros, non ultricies elit magna quis risus. Donec lacinia vel mi id tincidunt. Nulla tincidunt enim pretium lacus rhoncus sollicitudin. Cras venenatis, magna at laoreet egestas, metus tortor consectetur arcu, dictum laoreet eros tellus non massa. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec et sem hendrerit, pretium nibh ac, malesuada libero.                    <p>
                    <h2>More text:</h2>
                    <p>
                        Duis eget bibendum mauris. Donec sed lacus dapibus, semper nibh malesuada, lobortis leo. Suspendisse non tempus ligula, id suscipit sem. Fusce lobortis, quam nec maximus tincidunt, nunc sapien sodales purus, quis fringilla neque tortor in tellus. Pellentesque pharetra ultrices augue nec tempor. Integer pharetra metus nulla, in lacinia mauris dapibus eget. Nam eleifend tristique lectus a auctor. Vestibulum nec sodales dui, scelerisque varius velit. Nam imperdiet dui a sodales elementum. Mauris sit amet dolor id nunc rutrum accumsan in eu nisi. Sed eu odio et ligula dictum dapibus at vitae leo. Vivamus semper imperdiet felis at pellentesque. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.
                    </p>
                    <h2>Some more:</h2>
                    <p>
                        Aenean pretium nulla at quam ultricies facilisis. Mauris ultricies lectus in tellus rutrum pellentesque. Ut non convallis est, nec semper diam. Nunc tortor quam, bibendum nec mi eget, viverra porta tortor. Morbi ornare massa ut enim efficitur, vel porttitor nulla facilisis. Aliquam tempus purus ligula, sed sollicitudin ante gravida at. Nunc dapibus metus eget vulputate efficitur. Suspendisse lobortis mauris vitae massa convallis mollis. Fusce eget tellus est. Fusce aliquam volutpat risus eget luctus.
                    </p>
                        <!--
                    <h2 style="border-bottom: black dotted 1px; display: inline-block">
                        Even more:
                    </h2>
                    <p>
                        Dette er tips basert på tilbakemeldinger vi har fått fra studenter over flere år:
                    </p>
                    <ul>
                        <li>
                            Husk at dere snakker for I &amp; IKT-studenter. Ikke vær redd for å bruke fagbegreper de burde kjenne til.
                        </li>
                        <li>
                            Forsøk å skille dere ut fra andre bedrifter hva er det som gjør nettopp dere til den mest attraktive arbeidsgiveren?
                        </li>
                        <li>
                            Fokuser på hvordan det er å arbeide i deres bedrift sosialt, arbeidsoppgaver, arbeidsmiljø, utfordringer. Vis gjerne bilder fra arbeidsplassen.</li>
                        <li>
                            Organisasjonsinndeling, økonomi og administrasjon er ofte mindre interessant når det kommer til å velge jobb. Forsøk å legg mindre vekt på dette enn de overnevnte punkter.</li>
                        <li>
                            Begrens presentasjonen til 45 minutter.</li>
                        <li>
                            Ta med en nyutdannet sivilingeniør fra NTNU, samt en fra HR.</li>
                        <li>
                            Still med flere personer, slik at det er enklere å komme i kontakt med dere under bespisningen.</li>
                    </ul>
                    -->
                    <!--
                    <h2>Final paragraph:</h2>
                    <p>
                        Nam ut leo pharetra, venenatis justo non, ultrices nibh. Mauris dolor nisi, venenatis ac interdum nec, ultrices eu velit. Nunc mattis maximus congue. Fusce semper sapien eu enim scelerisque, vel faucibus elit gravida. Vivamus ultrices justo non orci molestie, sed molestie ex placerat. Quisque blandit mauris nec nibh porta placerat. Suspendisse rutrum, augue vitae tincidunt bibendum, tellus ipsum sollicitudin arcu, ac efficitur dui sapien at est. Nam suscipit nulla non lectus aliquam congue eu ac ante. Aenean id lobortis nulla. Aliquam lacinia, orci in maximus blandit, est ligula tincidunt nibh, sit amet ultricies quam ligula ultrices velit. Suspendisse eu ante non quam congue gravida a at erat. Curabitur nec finibus augue, ac luctus tortor.
                    </p>
                    -->
                </div>
            </div>
        </div>
    </div>
</div>
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/staticpages/views/bedkom.scala.html
                  HASH: 0aff90e45cb6938d676b90c561e69bbe7af3a388
                  MATRIX: 811->0|2593->1755|2642->1795|2682->1797|2725->1822|2738->1826|2777->1827|2838->1856
                  LINES: 29->1|59->31|59->31|59->31|59->31|59->31|59->31|59->31
                  -- GENERATED --
              */
          