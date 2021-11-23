import { BrowserRouter, Routes, Route } from 'react-router-dom';
import BrasilAPI from '../components/BrasilAPI';
import ViaCEP from '../components/ViaCEP'
import Home from '../components/Home'

const RouteList = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/viacep" element={<ViaCEP />} />
                <Route path="/brasilapi" element={<BrasilAPI />} />
            </Routes>
        </BrowserRouter>
    
     );
}
 
export default RouteList;