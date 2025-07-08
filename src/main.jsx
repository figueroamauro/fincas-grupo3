import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import Navigation from './components/Navigation/Navigation.jsx'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <Navigation>
    <App />
    </Navigation>
  </StrictMode>,
)
