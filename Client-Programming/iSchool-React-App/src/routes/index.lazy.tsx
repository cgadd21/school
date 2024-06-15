import { createLazyFileRoute } from '@tanstack/react-router';
import { Index } from '../components/pages/index/index';

/** Lazy load index route. */
export const Route = createLazyFileRoute('/')({
  component: Index,
});
