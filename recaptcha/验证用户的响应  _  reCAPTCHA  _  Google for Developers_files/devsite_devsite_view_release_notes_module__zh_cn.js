(function(_ds){var window=this;var bha=function(){var a;const b=null!=(a=document.body.getAttribute("type"))?a:"";var c;a=null!=(c=document.body.getAttribute("template"))?c:"";c="article blog guide landing lcat marketing pricing product reference release_notes sample support topic".split(" ");return["page","project","support","topic"].includes(a)&&c.includes(b)},N8=class extends _ds.kA{constructor(){super(["devsite-dialog","devsite-dropdown-list","devsite-view-release-notes-dialog"]);this.Zn=!1;this.releaseNotes=new Map;this.g=
null;this.path="";this.label="\u67e5\u770b\u7248\u672c\u8bf4\u660e";this.disableAutoOpen=!1}gb(){return this}async connectedCallback(){super.connectedCallback();if(bha()){try{this.path||(this.path=await _ds.Tp(_ds.E().href));let a,b=null!=(a=await _ds.jB(new _ds.YA,this.path))?a:[];b=b.map(c=>{var d,e=Object,f=e.assign,g=null!=(d=c.publishedAt)?d:"";d=new Date(null!=g?g:"");g=d.toDateString().split(/\s+/);return f.call(e,{},c,{publishedAt:4===g.length?`${g[1]} ${Number(g[2])}, ${g[3]}`:d.toDateString()})});
b.forEach(c=>{let d;const e=null!=(d=c.publishedAt)?d:"";let f;this.releaseNotes.set(e,[...(null!=(f=this.releaseNotes.get(e))?f:[]),c])})}catch(a){}0===this.releaseNotes.size?this.remove():(this.Zn=!0,this.disableAutoOpen||"#release__notes"!==location.hash||this.h())}else this.remove()}disconnectedCallback(){super.disconnectedCallback();let a;null==(a=this.g)||a.remove();this.g=null}h(a){a&&(a.preventDefault(),a.stopPropagation());let b;null==(b=this.g)||b.remove();this.g=document.createElement("devsite-dialog");
this.g.classList.add("devsite-view-release-notes-dialog-container");_ds.Gz((0,_ds.Q)`
      <devsite-view-release-notes-dialog
        .releaseNotes=${this.releaseNotes}>
      </devsite-view-release-notes-dialog>
    `,this.g);document.body.appendChild(this.g);this.g.open=!0;this.Ga({category:"Site-Wide Custom Events",action:"release notes: view note",label:`${this.path}`})}render(){return this.Zn?(0,_ds.Q)`
      <a class="view-notes-link"
         href="#"
         @click="${this.h}">
        ${this.label}
      </a>
    `:(0,_ds.Q)``}};_ds.x([_ds.M(),_ds.y(Object)],N8.prototype,"Zn",void 0);_ds.x([_ds.K({type:String}),_ds.y(Object)],N8.prototype,"path",void 0);_ds.x([_ds.K({type:String}),_ds.y(Object)],N8.prototype,"label",void 0);_ds.x([_ds.K({type:Boolean,Ha:"disable-auto-open"}),_ds.y(Object)],N8.prototype,"disableAutoOpen",void 0);try{window.customElements.define("devsite-view-release-notes",N8)}catch(a){console.warn("devsite.app.customElement.DevsiteViewReleaseNotes",a)};})(_ds_www);
