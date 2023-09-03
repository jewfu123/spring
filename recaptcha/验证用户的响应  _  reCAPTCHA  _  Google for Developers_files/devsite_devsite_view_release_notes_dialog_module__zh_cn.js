(function(_ds){var window=this;var Xga=function(a){a.eventHandler.listen(a,"DropdownItemClicked",b=>{Wga(a,b)})},Wga=async function(a,b){const c=b.Ia.detail.id;b=a.querySelector(".devsite-dialog-contents");const d=a.querySelector(`#date-section-${c}`);let e,f,g,h;const k=(null!=(g=null==d?void 0:null==(e=d.getBoundingClientRect())?void 0:e.top)?g:0)-(null!=(h=null==b?void 0:null==(f=b.getBoundingClientRect())?void 0:f.top)?h:0);d&&b&&b.scrollBy({top:k,behavior:"smooth"});let l,m;a.Wh=null!=(m=null==(l=a.bj.find(n=>n.id===c))?void 0:
l.title)?m:"";a.g.Oa(a.Wh)},Zga=function(a){const b=new IntersectionObserver(c=>{c.forEach(d=>{Yga(a,0<d.intersectionRatio,d)})},{root:a.querySelector(".devsite-dialog-contents")});a.querySelectorAll(".release-note-date-section .release-note").forEach(c=>{b.observe(c)})},Yga=function(a,b,c){let d,e;const f={id:null!=(d=c.target.getAttribute("id"))?d:"",type:null!=(e=c.target.getAttribute("type"))?e:"NOTE_TYPE_UNSPECIFIED"};if(b){let g;a.og=[...(null!=(g=a.og)?g:[]),f]}else a.og=[...a.og.filter(g=>
g.id!==f.id)]},$ga=function(a){switch(a){case "NOTE_TYPE_FEATURE":return{title:"Feature",color:"green"};case "NOTE_TYPE_SERVICE_ANNOUNCEMENT":return{title:"Announcement",color:"yellow"};case "NOTE_TYPE_NON_BREAKING_CHANGE":return{title:"Change",color:"yellow"};case "NOTE_TYPE_LIBRARIES":return{title:"Libraries",color:"blue"};case "NOTE_TYPE_FIX":return{title:"Fixed",color:"blue"};case "NOTE_TYPE_BREAKING_CHANGE":return{title:"Breaking",color:"red"};case "NOTE_TYPE_DEPRECATION":return{title:"Deprecated",
color:"red"};case "NOTE_TYPE_ISSUE":return{title:"Issue",color:"red"};case "NOTE_TYPE_SECURITY_BULLETIN":return{title:"Security",color:"orange"};default:return{title:"Unspecified",color:"grey"}}},L8=function(a,b){b=$ga(b);return(0,_ds.Q)`
        <span class="release-note-type-chip
          ${a} ${b.color}">
          ${"large"===a?b.title.toUpperCase():b.title}
        </span>`},aha=function(a,b){let c;return(0,_ds.Q)`
        <div class="release-note-date-section"
        id="date-section-${b.replace(/,?\s/g,"")}">
          <h3 class="release-note-date-header">${b}</h3>
          ${[...(null!=(c=a.releaseNotes.get(b))?c:[])].map((d,e)=>{let f,g;return(0,_ds.Q)`
                <div class="release-note"
                    id="${`${b}-${e}`}"
                    type="${null!=(f=d.noteType)?f:"NOTE_TYPE_UNSPECIFIED"}">
                  ${L8("large",d.noteType)}
                  <div class="release-note-content">
                  ${d.descriptionHtml?(0,_ds.dC)(_ds.ae(null!=(g=d.descriptionHtml)?g:"")):(0,_ds.Q)`<p>${d.description}</p>`}
                  </div>
                </div>`})}
        </div>
    `},M8=class extends _ds.kA{constructor(){super(["devsite-dialog","devsite-dropdown-list"]);this.eventHandler=new _ds.F;this.releaseNotes=new Map;this.Wh="";this.bj=[];this.og=[];this.g=new _ds.bm(async a=>{this.Ga({category:"Site-Wide Custom Events",action:"release notes: view old note",label:`${await _ds.Tp(_ds.E().href)} : ${a}`})},100)}gb(){return this}async connectedCallback(){super.connectedCallback();this.Wh=[...this.releaseNotes.keys()][0];this.bj=[...this.releaseNotes.keys()].map(a=>({id:a.replace(/,?\s/g,
""),title:a}));Xga(this)}disconnectedCallback(){super.disconnectedCallback()}cc(a){super.cc(a);Zga(this)}render(){return(0,_ds.Q)`
      <div class="devsite-dialog-header">
        <div>
          <h3 class="no-link title">
            Release note
          </h3>
          <div class="chip-wrapper">
            ${[...(new Set(this.og.map(a=>a.type)))].map(a=>L8("small",a))}
          </div>
        </div>
        <devsite-dropdown-list
            .listItems=${this.bj}>
          <p slot="toggle" class="selected-date-toggle">${this.Wh}</p>
        </devsite-dropdown-list>
      </div>
      <div class="devsite-dialog-contents">
        ${[...this.releaseNotes.keys()].map(a=>aha(this,a))}
      </div>
      <div class="devsite-dialog-footer devsite-dialog-buttons">
        <button class="button devsite-dialog-close">
          Close
        </button>
      </div>`}};_ds.x([_ds.K({type:Map}),_ds.y(Object)],M8.prototype,"releaseNotes",void 0);_ds.x([_ds.M(),_ds.y(Object)],M8.prototype,"Wh",void 0);_ds.x([_ds.M(),_ds.y(Array)],M8.prototype,"bj",void 0);_ds.x([_ds.M(),_ds.y(Array)],M8.prototype,"og",void 0);try{window.customElements.define("devsite-view-release-notes-dialog",M8)}catch(a){console.warn("devsite.app.customElement.DevsiteViewReleaseNotesDialog",a)};})(_ds_www);
