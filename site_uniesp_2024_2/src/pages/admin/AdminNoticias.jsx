import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import axios from 'axios'
import { Button, List, ListItem, ListItemText, Typography, Box, Paper } from '@mui/material'

const url = "http://localhost:3000/noticias"

const AdminNoticias = () => {
  const [noticias, setNoticias] = useState([])

  useEffect(() => {
    const fetchData = async () => {
      try {
        const res = await axios.get(url)
        setNoticias(res.data)
      } catch (error) {
        console.error("Erro ao buscar as notícias: ", error)
      }
    }
    fetchData()
  }, [])

  const removerNoticia = async (id) => {
    try {
      await axios.delete(`${url}/${id}`)
      setNoticias(noticias.filter(noticia => noticia.id !== id))
    } catch (error) {
      console.error("Erro ao remover a notícia: ", error)
    }
  }

  return (
    <Box sx={{ p: 4, backgroundColor: '#f9f9f9', borderRadius: '8px' }}>
      <Typography variant="h4" gutterBottom>Gerenciar Notícias</Typography>
      <Button variant="contained" color="primary" component={Link} to="/cadastrar-noticia" sx={{ mb: 2 }}>
        Cadastrar Nova Notícia
      </Button>
      <List>
        {noticias.map((noticia) => (
          <ListItem key={noticia.id} divider component={Paper} sx={{ mb: 2, p: 2, backgroundColor: '#ffffff', borderRadius: '8px' }}>
            <ListItemText primary={noticia.titulo} secondary={noticia.subtitulo} />
            <Button variant="contained" color="secondary" component={Link} to={`/editar-noticia/${noticia.id}`} sx={{ mr: 1 }}>
              Editar
            </Button>
            <Button variant="contained" color="error" onClick={() => removerNoticia(noticia.id)}>
              Remover
            </Button>
          </ListItem>
        ))}
      </List>
    </Box>
  )
}

export default AdminNoticias
