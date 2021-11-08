import './style.css';

const Footer = () => {

    const generateDateString = () => {
        const creationYear = '2021';
        const currentYear = String(new Date().getFullYear());
        return creationYear === currentYear ? currentYear : `${creationYear} - ${currentYear}`
    }

    return (
        <footer id="footer">
            <h3>Todos os direitos reservador. &copy;Copyright {generateDateString()}</h3>
        </footer>
    )
}


export default Footer;