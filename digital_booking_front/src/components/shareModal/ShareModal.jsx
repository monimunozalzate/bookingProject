import React, {useState, useRef } from "react";
import styles from "./ShareModal.module.css";
import {
  EmailShareButton,
  FacebookShareButton,
  LinkedinShareButton,
  TwitterShareButton,
  WhatsappShareButton,
  PinterestShareButton,
} from "react-share";
import {
  EmailIcon,
  FacebookIcon,
  LinkedinIcon,
  PinterestIcon,
  TwitterIcon,
  WhatsappIcon,
} from "react-share";

const ShareModal = ({dataProductDetails, productDetailsPath, setIsShown, modRef}) => {

function handleClose(){
  setIsShown(false)
}

  return (
    <div className={styles.shareModalContainer} ref= {modRef}>
      <section style={{display:'flex', flexDirection:'column',gap:'0.5rem'}}>
        <h1>Compartir via</h1>
        <p>Click en uno de los iconos para compartir</p>
      </section>
      <section className={styles.media}>
        <EmailShareButton>
          <EmailIcon />
        </EmailShareButton>
        <FacebookShareButton 
        url={productDetailsPath} 
        title={dataProductDetails.nombre} 
        text={dataProductDetails.descripcion}
        hashtags={dataProductDetails.titulo}
        >
          <FacebookIcon />
        </FacebookShareButton>
        <LinkedinShareButton>
          <LinkedinIcon />
        </LinkedinShareButton>
        <TwitterShareButton>
          <TwitterIcon />
        </TwitterShareButton>
        <WhatsappShareButton>
          <WhatsappIcon />
        </WhatsappShareButton>

        <PinterestShareButton>
          <PinterestIcon />
        </PinterestShareButton>
      </section>
      <button className={styles.cancelButton} onClick={handleClose}>
        Cancelar
      </button>
    </div>
  );
};

export default ShareModal;
