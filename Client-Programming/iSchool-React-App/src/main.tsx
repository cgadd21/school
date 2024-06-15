import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import { SWRConfig } from 'swr';
import { RouterProvider, createRouter } from '@tanstack/react-router';
import { routeTree } from './routeTree.gen';

const fetcher = (url: string) => fetch(url).then((res) => res.json());

const baseUrl = '/ctg7866/ISTE340/project2/';

const router = createRouter({
  routeTree,
  basepath: baseUrl,
});

declare module '@tanstack/react-router' {
  interface Register {
    router: typeof router;
  }
}

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <SWRConfig value={{ fetcher }}>
      <RouterProvider router={router} />
    </SWRConfig>
  </React.StrictMode>,
);
