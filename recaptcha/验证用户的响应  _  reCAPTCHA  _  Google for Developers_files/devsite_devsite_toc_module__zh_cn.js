(function(_ds){var window=this;var tga=function(a){const b=a.Sx,c=a.kd,d=a.Hu;a=a.hw;let e;e='<ul class="devsite-nav-list"><li class="devsite-nav-item devsite-nav-heading devsite-toc-toggle" role="heading" aria-level="2"><span class="devsite-nav-title"><span class="devsite-nav-text">\u672c\u9875\u5185\u5bb9</span></span>';c&&(e=e+'<button type="button" title="'+_ds.AH("\u5c55\u5f00/\u6536\u8d77\u5185\u5bb9"),e+='" class="devsite-nav-show-all button-transparent material-icons"></button>');e+="</li>";const f=b.length;for(let h=0;h<
f;h++){var g=b[h];e+='<li class="devsite-nav-item"'+(c&&g.index<a?" visible":"")+'><a href="#'+_ds.X(g.id)+'" class="devsite-nav-title gc-analytics-event" data-category="Site-Wide Custom Events" data-action="click" data-label="'+(c?"Embedded nav":"Right nav")+'" data-value="'+_ds.X(h)+'" track-type="navigation" track-name="'+(c?"embeddedNav":"rightNav")+'" track-metadata-position="'+_ds.X(h)+'" track-metadata-link-destination="#'+_ds.X(g.id)+'"><span class="devsite-nav-text" tooltip>'+_ds.S(g.text)+
"</span></a>";if(_ds.T(g.children).length){e+='<ul class="devsite-nav-list">';g=g.children;const k=g.length;for(let l=0;l<k;l++){const m=g[l];e+='<li class="devsite-nav-item"'+(c&&m.index<a?" visible":"")+'><a href="#'+_ds.X(m.id)+'" class="devsite-nav-title gc-analytics-event" data-category="Site-Wide Custom Events" data-action="click" data-label="'+(c?"Embedded nav":"Right nav")+'" data-value="'+_ds.X(h)+"."+_ds.X(l)+'" track-type="navigation" track-name="'+(c?"embeddedNav":"rightNav")+'" track-metadata-position="'+
_ds.X(h)+"."+_ds.X(l)+'" track-metadata-link-destination="#'+_ds.X(m.id)+'"><span class="devsite-nav-text" tooltip>'+_ds.S(m.text)+"</span></a></li>"}e+="</ul>"}e+="</li>"}d&&(e=c?e+'<li class="devsite-nav-item devsite-apix-link"><a href="#try-it" class="devsite-nav-title"><span class="devsite-nav-text" tooltip>\u8bd5\u7528</span></a></li>':e+'<button type="button" class="devsite-show-apix button-primary">\u8bd5\u8bd5\u770b\uff01</button>');c&&(e=e+'<li class="devsite-toc-toggle"><button type="button" class="button-flat devsite-nav-more-items material-icons" track-type="navigation" track-name="embeddedNavExpand" title="'+
_ds.AH("\u5c55\u5f00/\u6536\u8d77\u5185\u5bb9"),e+='"></button></li>');return(0,_ds.R)(e+"</ul>")};var B8=function(a){if(!a.hasAttribute("disabled")){var b=document.querySelector("devsite-content .devsite-article-body");b?(a.kd?a.classList.add("devsite-toc-embedded"):a.classList.add("devsite-toc"),uga(a,b),a.qa=!0):a.Gb()}},wga=async function(a){await vga(a);if(a.g){var b=`#${a.g.id}`,c=encodeURI(b);b=a.ea.get(b)||a.ea.get(c);a.o!==b&&(a.o&&a.o.classList.remove("devsite-nav-active"),b&&(b.classList.add("devsite-nav-active"),a.ma&&("scrollIntoViewIfNeeded"in b?b.scrollIntoViewIfNeeded():b.scrollIntoView()),
a.o=b))}},xga=function(a){a.kd||a.eventHandler.listen(document.body,"devsite-content-updated devsite-element-hidden devsite-element-visible devsite-page-loaded devsite-sticky-resize devsite-sticky-scroll".split(" "),()=>{a.ra.Oa()});a.eventHandler.listen(document.body,"devsite-content-updated",()=>{B8(a)})},yga=async function(a){if("IntersectionObserver"in _ds.lj()){a.dc&&a.dc.disconnect();var b=document.querySelector("devsite-header");let c=152;b&&(await window.customElements.whenDefined("devsite-header"),
(b=Number(b.getAttribute("top-row--height"))+Number(b.getAttribute("bottom-row--height")))&&(c=b));a.dc=new IntersectionObserver(d=>{for(const e of d)e.isIntersecting?a.v.add(e.target):a.v.delete(e.target);a.ra.Oa()},{rootMargin:`${c}px 0px 0px 0px`,threshold:[0,1]})}a.ua.g()},vga=async function(a){let b=0;var c=document.querySelector("devsite-header");c&&(await window.customElements.whenDefined("devsite-header"),b=c.v());c=a.h.findIndex(e=>a.v.has(e)&&e.getBoundingClientRect().top>=b);const d=a.h[c];
if(d){const e=await zga();d.getBoundingClientRect().top-b>e&&0<c?a.g=a.h[c-1]:a.g=d}else a.g&&a.g.getBoundingClientRect().top>window.innerHeight&&(c=a.h.indexOf(a.g),0<c&&(a.g=a.h[c-1]))},uga=function(a,b){const c=[];let d=!1,e="";switch(a.getAttribute("depth")){case "1":e="h2:not(.hide-from-toc):not(#contents):not(#table-of-contents)";break;default:e="h2:not(.hide-from-toc):not(#contents):not(#table-of-contents), h3:not(.hide-from-toc):not(#contents):not(#table-of-contents)"}a.h=[...b.querySelectorAll(e)].filter(f=>
f.id&&f.dataset.text).filter(f=>Aga(f));for(const [f,g]of a.h.entries())b=g,b={id:b.id,level:b.tagName.toLowerCase(),text:b.dataset.text,children:[],index:f},"h2"===b.level?(c.push(b),d=!0):d?c[c.length-1].children.push(b):c.push(b);_ds.vb(a.oa,c,a.va.bind(a))&&a.qa||(c.length?(Bga(a,c),a.show(),a.kd||Cga(a)):a.Gb(),a.oa=c)},Aga=function(a){return _ds.cl.find(b=>!!_ds.Lj(a,null,b,6))||_ds.Lj(a,"devsite-selector",null,6)||_ds.Lj(a,null,"devsite-dialog",3)?!1:!0},Bga=function(a,b){const c=_ds.O(tga,
{Sx:b,kd:a.kd,Hu:!!document.body.querySelector("devsite-apix, .devsite-apix"),hw:8>b.length?8:5});b=c.querySelectorAll("a.devsite-nav-title");for(const d of b){b=d;const e=b.hash,f=encodeURI(b.hash);a.ea.set(e,b);a.ea.set(f,b)}_ds.rj(a);a.kd&&_ds.C(a,"hidden","",c);a.appendChild(c);if(a.kd){if(8<a.getElementsByClassName("devsite-nav-item").length){for(const d of a.querySelectorAll(".devsite-nav-show-all, .devsite-nav-more-items"))a.eventHandler.listen(d,"click",()=>{a.hasAttribute("expanded")?a.removeAttribute("expanded"):
_ds.C(a,"expanded","")});_ds.C(a,"expandable","")}else a.removeAttribute("expandable");setTimeout(()=>{c.removeAttribute("hidden")},0)}},Cga=async function(a){await a.ua.promise;if(a.dc){a.dc.disconnect();a.v.clear();a.o&&a.o.classList.remove("devsite-nav-active");a.o=null;for(const b of a.h)a.dc.observe(b)}},zga=async function(){let a=0,b=0;const c=document.querySelector("devsite-header");c&&(await window.customElements.whenDefined("devsite-header"),a=c.v(),b=c.ua());return Math.max(b-a,Math.floor((window.innerHeight-
a)/5))},C8=class extends _ds.D{static get observedAttributes(){return["max-height","offset"]}constructor(){super();this.eventHandler=new _ds.F;this.ua=new _ds.hm;this.v=new Set;this.ea=new Map;this.xa=new _ds.bm(()=>void B8(this),16);this.ra=new _ds.bm(()=>void wga(this),33);this.g=this.o=null;this.h=[];this.qa=!1;this.dc=null;this.ma=this.kd=!1;this.oa=[];_ds.oi(this,(0,_ds.u)`disabled`,(0,_ds.u)`has-sidebar`,(0,_ds.u)`hidden`,(0,_ds.u)`expandable`,(0,_ds.u)`expanded`,(0,_ds.u)`visible`)}connectedCallback(){this.kd=
this.hasAttribute("devsite-toc-embedded");this.ma=document.body.hasAttribute("concierge");B8(this);xga(this)}disconnectedCallback(){this.Gb();this.qa=!1;_ds.H(this.eventHandler)}ck(a){a=a&&"false"===a.toLowerCase();this.oa=[];_ds.rj(this);a?(_ds.C(this,"disabled",""),this.Gb()):(this.removeAttribute("disabled"),this.show(),this.xa.Oa())}Gb(){_ds.rj(this);this.dispatchEvent(new CustomEvent("devsite-element-hidden",{bubbles:!0}));this.removeAttribute("visible");_ds.C(this,"hidden","");if(!this.kd&&
!this.ma){const a=document.querySelector(".devsite-main-content");a&&a.removeAttribute("has-sidebar")}}show(){this.dispatchEvent(new CustomEvent("devsite-element-visible",{bubbles:!0}));this.removeAttribute("hidden");_ds.C(this,"visible","");if(!this.kd){const a=document.querySelector(".devsite-main-content");a&&_ds.C(this,"has-sidebar","",a);yga(this)}}va(a,b){let c=!0;if(a.children.length||b.children.length)c=_ds.vb(a.children,b.children,this.va.bind(this));return c&&a.id===b.id&&a.text===b.text}};
C8.prototype.renderUpdatedContent=C8.prototype.ck;C8.prototype.disconnectedCallback=C8.prototype.disconnectedCallback;C8.prototype.connectedCallback=C8.prototype.connectedCallback;try{window.customElements.define("devsite-toc",C8)}catch(a){console.warn("Unrecognized DevSite custom element - DevsiteToc",a)};})(_ds_www);
