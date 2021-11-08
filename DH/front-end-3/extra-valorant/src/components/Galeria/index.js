import './style.css';
import Video from '../Video';

const Galeria = () => {
    return (
        <section id="galeria">
            <div className="grid">
                <Video url="https://medal.tv/clip/2Mqmi2BBV7EJ3/vpTnDq89J?invite=cr-MSwxVWksMTAxNzA2MDIs" title="4K Play" />
                <Video url="https://www.youtube.com/embed/bAhYH_mYhDg" title="Aulão com Belky" />
                <Video url="https://www.youtube.com/embed/rvrEEAT-tGo" title="A melhor pior jogada da vida" />
            </div>
        </section>
        
    )

}

export default Galeria;