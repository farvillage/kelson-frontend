import { Container, CssBaseline, Box } from '@mui/material'
import React from 'react'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Navbar from './components/Navbar'
import BannerAd from './components/BannerAd'
import Inicial from './pages/Inicial'
import Faculdade from './pages/Faculdade'
import DpoLgpd from './pages/DpoLgpd'
import Noticias from './pages/Noticias'
import VisualizaNoticia from './pages/VisualizaNoticia'
import AdminNoticias from './pages/admin/AdminNoticias'
import CadastroNoticia from './pages/admin/CadastroNoticias'
import EditarNoticia from './pages/admin/EditarNoticia'

const App = () => {
  return (
    <BrowserRouter>
      <CssBaseline />
      <Container maxWidth='lg' sx={{ backgroundColor: '#f7f7f7', minHeight: '100vh', padding: '16px', borderRadius: '8px'  }}>
        <Box display="flex" alignItems="center" justifyContent="space-between" p={2} sx={{ backgroundColor: '#fff', borderRadius: '8px', boxShadow: 1 }}>
          <Navbar />
        </Box>

        <BannerAd />

        <Box mt={4}>

          <Routes>
            <Route path="/" element={<Inicial />} />
            <Route path="/a-faculdade" element={<Faculdade />} />
            <Route path="/dpo-lgpd" element={<DpoLgpd />} />
            <Route path="/noticias" element={<Noticias />} />
            <Route path="/visualiza-noticia/:id" element={<VisualizaNoticia />} />
            <Route path="/admin-noticias" element={<AdminNoticias />} />
            <Route path="/cadastrar-noticia" element={<CadastroNoticia />} />
            <Route path="/editar-noticia/:id" element={<EditarNoticia />} />
          </Routes>

        </Box>

      </Container>
    </BrowserRouter>
  )
}

export default App